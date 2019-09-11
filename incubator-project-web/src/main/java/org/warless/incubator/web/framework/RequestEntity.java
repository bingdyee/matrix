package org.warless.incubator.web.framework;

import java.io.Serializable;

/**
 * codespot
 *
 * @author : Noa Swartz
 * @date: 2019-05-24
 * @email: fetaxyu@gmail.com
 */
public class RequestEntity implements Serializable {

    private static final long serialVersionUID = 1673420457937076559L;

    /** 版本号 默认为1 */
    public static final String DEFAULT_VERSION = "1";

    /**交易代码，即表示本报文处理方法的名称 */
    private String traCode;
    /** 流水号，一般用于去重 格式：系统ID(20)+年月日时分秒3位毫秒(17)+13位随机数(13) 共计50 */
    private String reqSeq;
    /** 签名，校验字段 */
    private String sign;
    /** 发送系统ID */
    private String sysId;
    /** 版本号 默认为1 */
    private String version;
    /** 签名类型 MD5|RSA|DES|3DES */
    private String signType = SignType.MD5.getType();
    /** 请求参数数据 */
    private Object data;

    public RequestEntity() {
        this.version = DEFAULT_VERSION;
    }

    public String getTraCode() {
        return traCode;
    }

    public RequestEntity setTraCode(String traCode) {
        this.traCode = traCode;
        return this;
    }

    public String getReqSeq() {
        return reqSeq;
    }

    public RequestEntity setReqSeq(String reqSeq) {
        this.reqSeq = reqSeq;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public RequestEntity setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getSysId() {
        return sysId;
    }

    public RequestEntity setSysId(String sysId) {
        this.sysId = sysId;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public RequestEntity setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getSignType() {
        return signType;
    }

    public RequestEntity setSignType(String signType) {
        this.signType = signType;
        return this;
    }

    public Object getData() {
        return data;
    }

    private RequestEntity setData(Object data) {
        this.data = data;
        return this;
    }

}