package org.warless.incubator.dubbo.simpledubbo.client;

public class DubboNode {

    private String root;
    private String interfaceName;
    private String consumers;
    private String configurators;
    private String routers;
    private String providers;

    public DubboNode(String root, String interfaceName, String child) {
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getConsumers() {
        return consumers;
    }

    public void setConsumers(String consumers) {
        this.consumers = consumers;
    }

    public String getConfigurators() {
        return configurators;
    }

    public void setConfigurators(String configurators) {
        this.configurators = configurators;
    }

    public String getRouters() {
        return routers;
    }

    public void setRouters(String routers) {
        this.routers = routers;
    }

    public String getProviders() {
        return providers;
    }

    public void setProviders(String providers) {
        this.providers = providers;
    }
}
