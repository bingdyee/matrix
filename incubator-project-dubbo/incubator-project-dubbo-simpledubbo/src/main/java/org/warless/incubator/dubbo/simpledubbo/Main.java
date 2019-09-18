package org.warless.incubator.dubbo.simpledubbo;

import org.warless.incubator.dubbo.simpledubbo.service.SPIService;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author : fetaxyu
 * @date : 2019-09-15
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        Iterator<SPIService> iterator = load.iterator();
        while(iterator.hasNext()) {
            SPIService ser = iterator.next();
            ser.execute("Noa");
        }
    }

}
