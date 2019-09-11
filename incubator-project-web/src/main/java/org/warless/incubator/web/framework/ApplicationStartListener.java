package org.warless.incubator.web.framework;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * codespot
 *
 * @author : Noa Swartz
 * @date: 2019-05-24
 * @email: fetaxyu@gmail.com
 */
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {

    static final Map<String, Entry> SERVICE_MAP = new HashMap<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(Service.class);
        beans.forEach((serviceId, service) -> {
            Class clazz = service.getClass();
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MethodAlias.class)) {
                    MethodAlias init = method.getAnnotation(MethodAlias.class);
                    String key = serviceId + init.value();
                    if (SERVICE_MAP.containsKey(key)) {
                        throw new RuntimeException("Service's id conflicts with existing! ->" + serviceId);
                    }
                    SERVICE_MAP.put(key, new Entry(service, method));
                }
            }
        });
    }

}
