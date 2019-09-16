package org.warless.incubator.dubbo.simpledubbo.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : fetaxyu
 * @date : 2019-09-15
 */
public class InMemoryRegister {

    private static Map<String, Class<?>> services = new HashMap<>();

    public static void regist(String interfaceName, Class<?> clazz) {
        services.put(interfaceName, clazz);
    }

    public static Class<?> getService(String interfaceName) {
        return services.get(interfaceName);
    }

}
