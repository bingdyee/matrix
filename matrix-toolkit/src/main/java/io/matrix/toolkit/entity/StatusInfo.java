package io.matrix.toolkit.entity;

/**
 * @author Noa Swartz
 * @date 2020/09/01
 */
public interface StatusInfo {

    /**
     * status code
     *
     * @return code
     */
    String getCode();

    /**
     * reason phrase of this status code
     *
     * @return reason
     */
    String getReason();

    default StatusInfo as(String desc) {
        StatusInfo statusInfo = this;
        return new StatusInfo() {
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
