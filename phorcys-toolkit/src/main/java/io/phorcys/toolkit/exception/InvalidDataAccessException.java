package io.phorcys.toolkit.exception;

/**
 * @author Noa Swartz
 */
public class InvalidDataAccessException extends RuntimeException {

    public InvalidDataAccessException() {
        super("Could not find table field！");
    }

    public InvalidDataAccessException(String message) {
        super(message);
    }

    public InvalidDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataAccessException(Throwable cause) {
        super(cause);
    }

}
