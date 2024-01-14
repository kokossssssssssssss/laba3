package Exceptions;

public class HeightOfTreeException extends Exception {
    public HeightOfTreeException() {
    }

    public HeightOfTreeException(String message) {
        super(message);
    }

    public HeightOfTreeException(String message, Throwable cause) {
        super(message, cause);
    }

    public HeightOfTreeException(Throwable cause) {
        super(cause);
    }

    public HeightOfTreeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
