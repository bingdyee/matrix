package org.warless.incubator.dubbo.simpledubbo.register;


import org.warless.incubator.dubbo.simpledubbo.framework.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : fetaxyu
 * @date : 2019-09-15
 */
public class RemoteRegister {

    private static Map<String, List<URL>> services = new HashMap<>();

    public static void regist(String interfaceName, URL url) {
        List<URL> list = services.getOrDefault(interfaceName, new ArrayList<>());
        list.add(url);
        services.put(interfaceName, list);
    }

}
