package org.warless.incubator.oauth2.sso.pojo;

import java.util.Date;

/**
 * @author : fetaxyu
 * @date : 2019-08-19
 */
public class BaseEntity {

    private Long id;
    private Date createTime;
    private Date updateTime;
    private Integer hasDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getHasDeleted() {
        return hasDeleted;
    }

    public void setHasDeleted(Integer hasDeleted) {
        this.hasDeleted = hasDeleted;
    }
}
