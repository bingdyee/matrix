package org.warless.incubator.oauth2.rbac.pojo.po;

import org.apache.ibatis.type.Alias;
import org.warless.incubator.oauth2.rbac.pojo.BaseEntity;

/**
 * @author fetaxyu
 * @date 2019-08-20
 */
@Alias("Role")
public class Role extends BaseEntity {

    private Long parentId;
    private String name;
    private String code;
    private Integer enable;
    private String description;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
