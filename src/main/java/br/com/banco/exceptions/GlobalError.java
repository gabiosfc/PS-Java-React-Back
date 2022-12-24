package br.com.banco.exceptions;

public class GlobalError {
    private String message;
    public GlobalError() {
    }

    public GlobalError(String message) {
        this.message = message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

