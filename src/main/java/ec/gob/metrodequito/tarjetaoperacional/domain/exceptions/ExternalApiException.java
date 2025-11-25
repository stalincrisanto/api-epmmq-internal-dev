package ec.gob.metrodequito.tarjetaoperacional.domain.exceptions;

public class ExternalApiException extends RuntimeException {
    public ExternalApiException(String message) {
        super(message);
    }
}
