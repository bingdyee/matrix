package io.github.matrix.commons.exception;

/**
 *
 *
 * @author Bing D. Yee
 * @date 2020/08/16
 */
public class JsonConvertException extends RuntimeException {

    public JsonConvertException() {
        super("Json Convert Exception！");
    }

    public JsonConvertException(String message) {
        super(message);
    }

    public JsonConvertException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonConvertException(Throwable cause) {
        super(cause);
    }

}
