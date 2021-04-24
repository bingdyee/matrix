package io.github.matrix.commons.exception;


import io.github.matrix.commons.model.status.StatusInfo;

/**
 * @author Bing D. Yee
 * @since 2021/04/07
 */
public class FieldConflictException extends AbstractWebException{

    public FieldConflictException(String message) {
        super(message);
    }

    public FieldConflictException(StatusInfo errorStatus) {
        super(errorStatus);
    }

    public FieldConflictException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }

}
