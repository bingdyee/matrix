package io.github.matrix.kits.exception;

/**
 * business exception
 *
 * @author Noa Swartz
 * @date 2020/09/25
 */
public class BusinessException extends AbstractException {

    private static final long serialVersionUID = 3014462528027130673L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(ErrorInfo errorInfo) {
        super(errorInfo);
    }

    public BusinessException(String errorCode, String errorDesc) {
        super(errorCode, errorDesc);
    }

}
