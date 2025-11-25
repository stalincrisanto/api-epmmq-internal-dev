package ec.gob.metrodequito.sistemacentralrecaudo.application.services;

import com.fasterxml.jackson.databind.JsonNode;
import ec.gob.metrodequito.sistemacentralrecaudo.application.dto.AccountAbtVerifier;
import ec.gob.metrodequito.sistemacentralrecaudo.application.ports.out.AccountAbtVerifierPort;
import ec.gob.metrodequito.tarjetaoperacional.utils.SearchType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AccountAbtVerifierService implements AccountAbtVerifierPort {

    private final WebClient externalCardAssignmentClient;

    @Override
    public AccountAbtVerifier accountAbtVerifier(SearchType type, String value) {

        return externalCardAssignmentClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("api/v1/card-assignment")
                        .queryParam("type", type.name())
                        .queryParam("value", value)
                        .build()
                )
                .retrieve()

                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        response -> response.bodyToMono(String.class)
                                .flatMap(body -> Mono.<Throwable>error(
                                        new RuntimeException("CLIENT_ERROR: " + body)
                                ))
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        response -> response.bodyToMono(String.class)
                                .flatMap(body -> Mono.<Throwable>error(
                                        new RuntimeException("SERVER_ERROR: " + body)
                                ))
                )

                .bodyToMono(JsonNode.class)
                .map(this::mapResponse)

                .onErrorReturn(new AccountAbtVerifier(false, null, null, null))

                .block();
    }

    private AccountAbtVerifier mapResponse(JsonNode body) {
        AccountAbtVerifier data = new AccountAbtVerifier();

        data.setSuccess(body.get("success").asBoolean());

        if (data.isSuccess()) {
            JsonNode dataNode = body.get("data");
            data.setFullName(dataNode.get("fullName").asText());
            data.setDocumentId(dataNode.get("documentId").asText());
            data.setEmail(dataNode.get("email").asText());
        }

        return data;
    }
}
