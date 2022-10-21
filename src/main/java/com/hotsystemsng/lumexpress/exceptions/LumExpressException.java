package com.hotsystemsng.lumexpress.exceptions;

public class LumExpressException extends Exception {
    public LumExpressException() {
        super();
    }

    public LumExpressException(String message) {
        super(message);
    }

    public LumExpressException(String message, Throwable cause) {
        super(message, cause);
    }

    public LumExpressException(Throwable cause) {
        super(cause);
    }
}
