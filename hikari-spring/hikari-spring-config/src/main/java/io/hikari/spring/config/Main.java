package io.hikari.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Noa Swartz
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext beans=new ClassPathXmlApplicationContext("classpath:spring-app.xml");
        Module module = (Module)beans.getBean("module");
        System.err.println(module);
    }

}
