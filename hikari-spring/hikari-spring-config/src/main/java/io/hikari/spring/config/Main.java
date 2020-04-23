package io.hikari.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ServiceLoader;

/**
 * @author Noa Swartz
 */
public class Main {

    public static void SPIMain() {
        ServiceLoader<HikariInterface> loaders = ServiceLoader.load(HikariInterface.class);
        if (loaders != null) {
            for (HikariInterface it : loaders) {
                it.test();
            }
        }
    }
    public static void springBeanParser() {
        ApplicationContext beans=new ClassPathXmlApplicationContext("classpath:spring-app.xml");
        Module module = (Module)beans.getBean("module");
        System.err.println(module);
    }

    public static void main(String[] args) {
        SPIMain();
    }

}
