package Exceptions;

public class OutOfTwigException extends Exception{
    public OutOfTwigException() {
    }

    public OutOfTwigException(String message) {
        super(message);
    }

    public OutOfTwigException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfTwigException(Throwable cause) {
        super(cause);
    }

    public OutOfTwigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
