package io.hikari.transaction.storage.pojo.dto;

import java.io.Serializable;

/**
 * @author Noa Swartz
 * @date 2020-04-04
 */
public class CommodityDTO implements Serializable {

    private static final long serialVersionUID = -6936696421884607586L;

    private Long id;
    private String commodityCode;
    private String name;
    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CommodityDTO{" +
                "id=" + id +
                ", commodityCode='" + commodityCode + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

}
