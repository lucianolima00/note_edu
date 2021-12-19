package com.example.noteedu.customExceptions;

public class NotFound extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NotFound() {
        System.out.println("Não encontrado(a)!");

    }

    public NotFound(String message) {
        super(message);

    }

    public NotFound(Throwable cause) {
        super(cause);

    }

    public NotFound(String message, Throwable cause) {
        super(message, cause);

    }

    public NotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
