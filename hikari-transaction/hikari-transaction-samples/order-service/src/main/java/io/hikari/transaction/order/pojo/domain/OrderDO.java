package io.hikari.transaction.order.pojo.domain;

import java.math.BigDecimal;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public class OrderDO {

    private Long id;
    private String orderNo;
    private Long userId;
    private String commodityCode;
    private Integer count;
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "OrderDO{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", userId=" + userId +
                ", commodityCode='" + commodityCode + '\'' +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }

}
