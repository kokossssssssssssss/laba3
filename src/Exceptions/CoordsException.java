package Exceptions;

public class CoordsException extends Exception{
    public CoordsException() {
    }

    public CoordsException(String message) {
        super(message);
    }

    public CoordsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoordsException(Throwable cause) {
        super(cause);
    }

    public CoordsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
