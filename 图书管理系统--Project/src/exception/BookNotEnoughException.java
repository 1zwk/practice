package exception;

public class BookNotEnoughException extends Exception {
    public BookNotEnoughException() {
    }

    public BookNotEnoughException(String message) {
        super(message);
    }

    public BookNotEnoughException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotEnoughException(Throwable cause) {
        super(cause);
    }

    public BookNotEnoughException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
