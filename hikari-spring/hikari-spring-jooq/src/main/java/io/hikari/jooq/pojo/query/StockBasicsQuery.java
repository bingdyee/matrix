package io.hikari.jooq.pojo.query;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Noa Swartz
 */
public class StockBasicsQuery {

    private String industry;
    private BigDecimal pe;
    private BigDecimal outstanding;
    private BigDecimal totals;
    private BigDecimal totalAssets;
    private BigDecimal liquidAssets;
    private BigDecimal reserved;
    private BigDecimal reservedPerShare;
    private Date launchTime;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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
}
