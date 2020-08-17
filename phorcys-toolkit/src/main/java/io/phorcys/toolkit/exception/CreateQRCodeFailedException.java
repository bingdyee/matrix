package io.phorcys.toolkit.exception;

/**
 * @author Noa Swartz
 * @date 2020-04-07
 */
public class CreateQRCodeFailedException extends RuntimeException {

    public CreateQRCodeFailedException() {
        super("Failed to create QRCode！");
    }

    public CreateQRCodeFailedException(String message) {
        super(message);
    }

    public CreateQRCodeFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateQRCodeFailedException(Throwable cause) {
        super(cause);
    }

}
