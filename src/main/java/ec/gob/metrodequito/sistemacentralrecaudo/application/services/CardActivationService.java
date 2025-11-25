package ec.gob.metrodequito.sistemacentralrecaudo.application.services;

import ec.gob.metrodequito.sistemacentralrecaudo.application.dto.CardActivationRequest;
import ec.gob.metrodequito.sistemacentralrecaudo.application.ports.out.CardActivationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CardActivationService implements CardActivationPort {

    private final WebClient externalCardAssignmentClient;

    @Override
    public void activateCard(CardActivationRequest request) {
        externalCardAssignmentClient.post()
                .uri("api/v1/card-activation")
                .bodyValue(request)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        resp -> resp.bodyToMono(String.class)
                                .flatMap(body -> Mono.error(new RuntimeException("CLIENT_ERROR: " + body)))
                )
                .onStatus(HttpStatusCode::is5xxServerError,
                        resp -> resp.bodyToMono(String.class)
                                .flatMap(body -> Mono.error(new RuntimeException("SERVER_ERROR: " + body)))
                )

                .toBodilessEntity()
                .block();
    }
}
