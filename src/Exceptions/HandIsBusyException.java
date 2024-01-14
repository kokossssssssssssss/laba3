package Exceptions;

public class HandIsBusyException extends Exception{
    public HandIsBusyException() {
    }

    public HandIsBusyException(String message) {
        super(message);
    }

    public HandIsBusyException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandIsBusyException(Throwable cause) {
        super(cause);
    }

    public HandIsBusyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
