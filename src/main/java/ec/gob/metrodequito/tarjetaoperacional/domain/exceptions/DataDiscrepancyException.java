package ec.gob.metrodequito.tarjetaoperacional.domain.exceptions;

public class DataDiscrepancyException extends RuntimeException {
    public DataDiscrepancyException(String message) {
        super(message);
    }
}
