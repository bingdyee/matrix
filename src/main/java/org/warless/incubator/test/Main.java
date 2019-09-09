package org.warless.incubator.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : fetaxyu
 * @date : 2019-09-09
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TestService testService = context.getBean(TestService.class);
        testService.hello();
    }

}
