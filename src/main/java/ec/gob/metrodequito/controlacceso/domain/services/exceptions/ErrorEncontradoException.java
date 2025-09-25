package ec.gob.metrodequito.controlacceso.domain.services.exceptions;

public class ErrorEncontradoException extends RuntimeException {

    public ErrorEncontradoException(String mensaje) {
        super(mensaje);
    }
}

