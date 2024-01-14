package Exceptions;

public class ShoesException extends Exception {
    public ShoesException() {
    }

    public ShoesException(String message) {
        super(message);
    }

    public ShoesException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShoesException(Throwable cause) {
        super(cause);
    }

    public ShoesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
