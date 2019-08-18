package org.warless.incubator.common.utils;

import org.apache.commons.lang3.StringUtils;


/**
 * @author fetaxyu
 * @date 2019-08-06
 */
public final class CryptoUtils {

    private static final String PADDING_CHAR = "\0";
    private static final String HEX_STR =  "0123456789ABCDEF";

    /**
     *
     * 将二进制转换为十六进制字符输出
     *
     * @param bytes bytes数组
     * @return 十六进制字符
     */
    public static String bytesToHexString(byte[] bytes) {
        if(bytes== null ){
            return null;
        }
        String result = "";
        String hex;
        for (byte aByte : bytes) {
            // 字节高4位
            hex = String.valueOf(HEX_STR.charAt((aByte & 0xF0) >> 4));
            // 字节低4位
            hex += String.valueOf(HEX_STR.charAt(aByte & 0x0F));
            result += hex;
        }
        return result;
    }

    /**
     *
     * 将十六进制转换为字节数组
     *
     * @param hexString 十六进制字符
     * @return bytes数组
     */
    public static byte[] hexStringToBytes(String hexString) {
        if(hexString == null ){
            return null;
        }
        // hexString的长度对2取整，作为bytes的长度
        int len = hexString.length() / 2;
        byte[] bytes = new byte[len];
        // 字节高四位、低四位
        byte high, low;
        for (int i = 0; i < len; i++) {
            // 右移四位得到高位
            high = (byte) ((HEX_STR.indexOf(hexString.charAt(2 * i))) << 4);
            low = (byte) HEX_STR.indexOf(hexString.charAt(2 * i + 1));
            //高地位做或运算
            bytes[i] = (byte) (high | low);
        }
        return bytes;
    }

    public static String padding(String iv, int len) {
        if (StringUtils.isBlank(iv) || len < 1) {
            return null;
        }
        int n = len - iv.length() % len;
        if (n < len) {
            for (int i = 0; i < n ; ++i) {
                iv += PADDING_CHAR;
            }
        }
        return iv;
    }

}
