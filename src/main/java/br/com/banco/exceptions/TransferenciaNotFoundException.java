package br.com.banco.exceptions;

public class TransferenciaNotFoundException extends RuntimeException {

    public TransferenciaNotFoundException(String message) {
        super(message);
    }

}
