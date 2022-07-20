package io.github.matrix.commons.exception;

import io.github.matrix.commons.model.status.StatusInfo;

/**
 * @author Bing D. Yee
 * @since 2022/04/18
 */
public class BusinessExecException extends AbstractWebException {

    public BusinessExecException(String message) {
        super(message);
    }

    public BusinessExecException(StatusInfo errorStatus) {
        super(errorStatus);
    }

    public BusinessExecException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }

}
