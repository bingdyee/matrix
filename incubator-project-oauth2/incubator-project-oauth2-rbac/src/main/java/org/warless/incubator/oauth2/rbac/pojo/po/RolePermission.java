package org.warless.incubator.oauth2.rbac.pojo.po;

import org.apache.ibatis.type.Alias;

/**
 * @author yubb
 * @date 2019-08-20
 */
@Alias("RolePermission")
public class RolePermission {

    private Long id;
    private Long roleId;
    private Long permissionId;
    private String roleCode;
    private String permissionCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }
}
