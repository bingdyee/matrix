package io.github.matrix.commons.model.entity;


import java.time.LocalDateTime;

/**
 * @author Bing D. Yee
 * @since 2021/04/24
 */
public class Entity {

    protected Long id;
    protected LocalDateTime createTime;
    protected LocalDateTime updateTime;
    protected Integer deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

}
