package io.hikari.oauth2.rbac.domain;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public class RoleDO {

    private Long id;
    private String name;
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
