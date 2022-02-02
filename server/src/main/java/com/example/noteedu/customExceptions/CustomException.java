package com.example.noteedu.customExceptions;

public class CustomException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CustomException() {
        String message= null;
        String cause =null;

        message= this.getMessage();
        cause = String.valueOf(this.getCause());

        System.out.println("Não encontrado(a)!");
        System.out.println(message);
        System.out.println(cause);

    }

    /**
     * @param message
     */
    public CustomException(String message) {
        super(message);

    }

    /**
     * @param cause
     */
    public CustomException(Throwable cause) {
        super(cause);

    }

    /**
     * @param message
     * @param cause
     */
    public CustomException(String message, Throwable cause) {
        super(message, cause);

    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

