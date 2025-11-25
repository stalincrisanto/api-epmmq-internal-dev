package ec.gob.metrodequito.tarjetaoperacional.domain.exceptions;

public class DataInconsistencyException extends RuntimeException {
    public DataInconsistencyException(String message) {
        super(message);
    }
}
