package io.hikari.spring.config;

/**
 * @author Noa Swartz
 */
public class Module {

    private String name;
    private String module;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "Module{" +
                "name='" + name + '\'' +
                ", module='" + module + '\'' +
                '}';
    }
}
