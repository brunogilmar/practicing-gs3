package br.com.abreutech.sgc.exception;

public class RegistroDuplicadoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RegistroDuplicadoException(String message) {
        super(message);
    }

}
