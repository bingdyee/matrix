package io.github.matrix.commons.exception;

/**
 *
 *
 * @author Bing D. Yee
 * @date 2020/08/16
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
