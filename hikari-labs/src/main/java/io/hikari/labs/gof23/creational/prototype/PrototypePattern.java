package io.hikari.labs.gof23.creational.prototype;

import io.hikari.common.util.BeanConverter;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * Prototype Pattern
 *
 * @author Noa Swartz
 * @date 2018-06-13
 */
public class PrototypePattern implements Cloneable, Serializable {

    private static final long serialVersionUID = -3756289850979478016L;

    private String name;
    private Date timestamp;

    public PrototypePattern(String name, Date timestamp) {
        this.name = name;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public PrototypePattern clone() {
//        try {
//            // shallow copy
//            return (Prototype) super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
        // deep copy
        return BeanConverter.clone(this);
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public static void main(String[] args) {
        PrototypePattern prototype1 = new PrototypePattern("Noa", new Date());
        PrototypePattern prototype2 = prototype1.clone();
        System.err.println(prototype1);
        System.err.println(prototype2);
    }

}
