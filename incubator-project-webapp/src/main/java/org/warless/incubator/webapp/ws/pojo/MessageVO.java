package org.warless.incubator.webapp.ws.pojo;

import java.util.Date;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-13
 */
public class MessageVO {

    private Long id;
    private String name;
    private String email;
    private Date birth;
    private Integer age;



    public Long getId() {
        return id;
    }

    public MessageVO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MessageVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public MessageVO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getBirth() {
        return birth;
    }

    public MessageVO setBirth(Date birth) {
        this.birth = birth;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public MessageVO setAge(Integer age) {
        this.age = age;
        return this;
    }
}
