package es.ua.dlsi.grfia.im3ws;

public class IM3WSException extends Exception {
    public IM3WSException() {
    }

    public IM3WSException(String message) {
        super(message);
    }

    public IM3WSException(String message, Throwable cause) {
        super(message, cause);
    }

    public IM3WSException(Throwable cause) {
        super(cause);
    }

    public IM3WSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
