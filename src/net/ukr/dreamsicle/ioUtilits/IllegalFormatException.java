package net.ukr.dreamsicle.ioUtilits;

/**
 * Created by Yura on 26.02.2017.
 */
public class IllegalFormatException extends Exception{
    public IllegalFormatException(String message) {
        super(message);
    }

    public IllegalFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
