package org.warless.incubator.dubbo.configcenter;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-06
 */
public class Main {

    public static void main(String[] args) {
        new EmbeddedZooKeeper(2181, false).start();
    }

}
