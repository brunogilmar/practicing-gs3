package br.com.abreutech.sgc.exception;

public class RegistroNaoExisteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RegistroNaoExisteException(String message) {
        super(message);
    }

}
