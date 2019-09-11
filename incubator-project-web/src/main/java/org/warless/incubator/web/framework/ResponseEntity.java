package org.warless.incubator.web.framework;

import java.io.Serializable;

/**
 * codespot
 *
 * @author : Noa Swartz
 * @date: 2019-05-24
 * @email: fetaxyu@gmail.com
 */
public class ResponseEntity implements Serializable {

    private static final long serialVersionUID = -8013107938385429989L;

    public static final String OK = "0000";

    /** 返回代码，0000表示正确，其它表示错误，一般表示系统级错误，数据级错误在报文体内表达【业务】*/
    private String reCode;
    /** 返回内容，在返回时如果为0000，表示成功一般可不写，非0000时，必须确认返回的错误是什么，DEBUG时可返回系统错误信息 */
    private String reMsg;
    /** 流水号，与请求时的流水号为同一，如异步调用则表示同一报文返回，有用订单号代替的。目前使用流水号 */
    private String reqSeq;
    /** 签名，本报文的校验字段，一般返回时不会校验 */
    private String sign;
    /** 返回代码，0000表示正确，其它表示错误，一般表示系统级错误，数据级错误在报文体内表达【接收】 */
    private String result;
    /** 返回数据 */
    private Object data;

    public ResponseEntity() {
        this.reCode = OK;
        this.reMsg = "OK.";
        this.result = OK;
    }

    public String getReCode() {
        return reCode;
    }

    public ResponseEntity setReCode(String reCode) {
        this.reCode = reCode;
        return this;
    }

    public String getReMsg() {
        return reMsg;
    }

    public ResponseEntity setReMsg(String reMsg) {
        this.reMsg = reMsg;
        return this;
    }

    public String getReqSeq() {
        return reqSeq;
    }

    public ResponseEntity setReqSeq(String reqSeq) {
        this.reqSeq = reqSeq;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public ResponseEntity setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getResult() {
        return result;
    }

    public ResponseEntity setResult(String result) {
        this.result = result;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResponseEntity setData(Object data) {
        this.data = data;
        return this;
    }

}
