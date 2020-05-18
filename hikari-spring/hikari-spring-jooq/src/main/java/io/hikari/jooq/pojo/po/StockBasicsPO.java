package io.hikari.jooq.pojo.po;

import io.hikari.common.pojo.BasePO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Noa Swartz
 */
public class StockBasicsPO extends BasePO {

    private String stockCode;
    private String companyName;
    private String industry;
    private String area;
    private BigDecimal pe;
    private BigDecimal outstanding;
    private BigDecimal totals;
    private BigDecimal totalAssets;
    private BigDecimal liquidAssets;
    private BigDecimal reserved;
    private BigDecimal reservedPerShare;
    private Date launchTime;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public BigDecimal getPe() {
        return pe;
    }

    public void setPe(BigDecimal pe) {
        this.pe = pe;
    }

    public BigDecimal getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(BigDecimal outstanding) {
        this.outstanding = outstanding;
    }

    public BigDecimal getTotals() {
        return totals;
    }

    public void setTotals(BigDecimal totals) {
        this.totals = totals;
    }

    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(BigDecimal totalAssets) {
        this.totalAssets = totalAssets;
    }

    public BigDecimal getLiquidAssets() {
        return liquidAssets;
    }

    public void setLiquidAssets(BigDecimal liquidAssets) {
        this.liquidAssets = liquidAssets;
    }

    public BigDecimal getReserved() {
        return reserved;
    }

    public void setReserved(BigDecimal reserved) {
        this.reserved = reserved;
    }

    public BigDecimal getReservedPerShare() {
        return reservedPerShare;
    }

    public void setReservedPerShare(BigDecimal reservedPerShare) {
        this.reservedPerShare = reservedPerShare;
    }

    public Date getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(Date launchTime) {
        this.launchTime = launchTime;
    }


    @Override
    public String toString() {
        return "StockBasicsPO{" +
                ", stockCode='" + stockCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", industry='" + industry + '\'' +
                ", area='" + area + '\'' +
                ", pe=" + pe +
                ", outstanding=" + outstanding +
                ", totals=" + totals +
                ", totalAssets=" + totalAssets +
                ", liquidAssets=" + liquidAssets +
                ", reserved=" + reserved +
                ", reservedPerShare=" + reservedPerShare +
                ", launchTime=" + launchTime +
                '}';
    }
}
