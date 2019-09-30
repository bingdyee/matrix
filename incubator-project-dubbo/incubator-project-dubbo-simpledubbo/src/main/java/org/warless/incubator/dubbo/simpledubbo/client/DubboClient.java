package org.warless.incubator.dubbo.simpledubbo.client;

import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.warless.incubator.dubbo.simpledubbo.common.Constants;
import org.warless.incubator.dubbo.simpledubbo.utils.URLParser;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

public class DubboClient {

    private static final String ZK_PATH = "127.0.0.1:2181";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    private CuratorFramework zkClient;

    public void init() {
        CuratorFrameworkFactory.Builder zkClientBuilder = CuratorFrameworkFactory.builder().
                connectString(ZK_PATH).
                retryPolicy(new ExponentialBackoffRetry(1000, 3));
        if (StringUtils.isNotEmpty(USERNAME) && StringUtils.isNotEmpty(PASSWORD)) {
            String auth = USERNAME + ":" + PASSWORD;
            zkClientBuilder.authorization("digest", auth.getBytes());
        }
        zkClient = zkClientBuilder.build();
        zkClient.start();
    }

    private List<String> getChildren(String... nodes) {
        String node = getNodePath(nodes);
        try {
            if (zkClient.checkExists().forPath(node) != null) {
                return zkClient.getChildren().forPath(node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getNodePath(String... nodes) {
        StringBuilder nodePath = new StringBuilder();
        for (String node : nodes) {
            nodePath.append(Constants.PATH_SEPARATOR).append(node);
        }
        return nodePath.toString();
    }

    public static void main(String[] args) throws Exception {
        DubboClient dubboClient = new DubboClient();
        dubboClient.init();
        List<String> interfaces = dubboClient.getChildren(Constants.ROOT_NODE);
        interfaces.forEach(interfaceName -> {
            List<String> providers = dubboClient.getChildren(Constants.ROOT_NODE, interfaceName, Constants.PROVIDERS_NODE);
            providers.forEach(provider -> {
                System.err.println(URLParser.unquote(provider));
            });
        });
    }

}
