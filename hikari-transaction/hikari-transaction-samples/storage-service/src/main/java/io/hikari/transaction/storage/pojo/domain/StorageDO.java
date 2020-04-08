package io.hikari.transaction.storage.pojo.domain;

/**
 * @author Noa Swartz
 * @date 2020-04-04
 */
public class StorageDO {

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
        return "StorageDO{" +
                "id=" + id +
                ", commodityCode='" + commodityCode + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

}
