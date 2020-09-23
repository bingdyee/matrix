package io.matrix.toolkit.exception;

import io.matrix.toolkit.entity.StatusInfo;

/**
 *
 *
 * @author Noa Swartz
 * @date 2020/09/02
 */
public interface ErrorInfo extends StatusInfo {

    /**
     * error code reuse
     *
     * @param desc err desc
     * @return err
     */
    @Override
    default ErrorInfo as(String desc) {
        StatusInfo statusInfo = this;
        return new ErrorInfo() {
            @Override
            public String getCode() {
                return statusInfo.getCode();
            }

            @Override
            public String getReason() {
                return desc;
            }
        };
    }

}
