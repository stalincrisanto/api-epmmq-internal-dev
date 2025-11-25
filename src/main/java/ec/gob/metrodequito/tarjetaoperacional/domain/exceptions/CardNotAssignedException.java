package ec.gob.metrodequito.tarjetaoperacional.domain.exceptions;

public class CardNotAssignedException extends RuntimeException {
    public CardNotAssignedException(String message) {
        super(message);
    }
}

