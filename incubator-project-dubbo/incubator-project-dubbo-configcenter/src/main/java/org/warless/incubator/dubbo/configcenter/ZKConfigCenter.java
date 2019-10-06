package org.warless.incubator.dubbo.configcenter;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-06
 */
public class ZKConfigCenter {

    private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");

    public static void main(String[] args) {
        CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperHost + ":2181", 60000, 60000,
                new ExponentialBackoffRetry(1000, 3));
        client.start();
    }


}
