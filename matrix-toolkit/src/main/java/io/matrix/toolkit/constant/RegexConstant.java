package io.matrix.toolkit.constant;

/**
 * @author vbintx
 * @date 2020/08/26
 */
public final class RegexConstant {

    public static final String ID_CARD_REG = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]$)";
    public static final String MOBILE_REG = "^1[345789]\\d{9}$";

    private RegexConstant() {}

}
