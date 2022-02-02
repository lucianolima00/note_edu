package com.example.noteedu.customExceptions;

public class WrongPassword extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public WrongPassword() {
        System.out.println("Senha incorrecta.");
    }

    public WrongPassword(String message) {
        super(message);
    }

    public WrongPassword(Throwable cause) {
        super(cause);
    }

    public WrongPassword(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPassword(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

}
