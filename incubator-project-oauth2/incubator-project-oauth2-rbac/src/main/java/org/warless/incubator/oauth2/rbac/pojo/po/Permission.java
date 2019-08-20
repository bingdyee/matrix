package org.warless.incubator.oauth2.rbac.pojo.po;

import org.apache.ibatis.type.Alias;
import org.warless.incubator.oauth2.rbac.pojo.BaseEntity;

/**
 * @author fetaxyu
 * @date 2019-08-20
 */
@Alias("Permission")
public class Permission extends BaseEntity {

    private Long parentId;
    private String name;
    private Integer type;
    private String permission;
    private String uri;
    private String method;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
