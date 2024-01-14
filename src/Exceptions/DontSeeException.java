package Exceptions;

public class DontSeeException extends Exception {
    public DontSeeException() {
    }

    public DontSeeException(String message) {
        super(message);
    }

    public DontSeeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DontSeeException(Throwable cause) {
        super(cause);
    }

    public DontSeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

