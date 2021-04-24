package io.github.matrix.commons.exception;


import io.github.matrix.commons.model.status.StatusCode;
import io.github.matrix.commons.model.status.StatusInfo;

/**
 * @author Bing D. Yee
 * @since 2021/04/07
 */
public class AbstractWebException extends RuntimeException {

    protected String errorCode;

    public AbstractWebException(String message) {
        this(StatusCode.INTERNAL_SERVER_ERROR.as(message));
    }

    public AbstractWebException(StatusInfo errorStatus) {
        this(errorStatus.getCode(), errorStatus.getMessage());
    }

    public AbstractWebException(String errorCode, String errorDesc) {
        super(errorDesc);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

}