package net.ukr.dreamsicle.io;

/**
 * Created by Yura on 27.02.2017.
 */
public class IllegalFormatException extends RuntimeException {
    public IllegalFormatException(String message) {
        super(message);
    }

    public IllegalFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFormatException(Throwable cause) {
        super(cause);
    }
}
