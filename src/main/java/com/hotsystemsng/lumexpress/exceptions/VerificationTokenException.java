package com.hotsystemsng.lumexpress.exceptions;

public class VerificationTokenException extends LumExpressException {
    public VerificationTokenException() {
        super();
    }

    public VerificationTokenException(String message) {
        super(message);
    }

    public VerificationTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerificationTokenException(Throwable cause) {
        super(cause);
    }
}
