package io.hikari.transaction.order.pojo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = -3795036877839175046L;

    private String orderNo;
    private Long userId;
    private String commodityCode;
    private Integer count;
    private BigDecimal amount;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
