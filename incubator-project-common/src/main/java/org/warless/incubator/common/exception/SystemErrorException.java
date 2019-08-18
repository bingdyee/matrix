package org.warless.incubator.common.exception;

/**
 * @author : yubb
 * @date : 2019-08-18
 */
public class SystemErrorException extends RuntimeException {

    public SystemErrorException(String message) {
        super(message);
    }

    public SystemErrorException(Throwable cause) {
        super(cause);
    }

    public SystemErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
