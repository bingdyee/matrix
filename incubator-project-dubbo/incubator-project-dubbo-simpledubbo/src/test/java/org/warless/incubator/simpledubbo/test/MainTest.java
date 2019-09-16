package org.warless.incubator.simpledubbo.test;

import org.junit.Test;
import org.warless.incubator.dubbo.simpledubbo.framework.URL;
import org.warless.incubator.dubbo.simpledubbo.protocol.http.HttpServer;
import org.warless.incubator.dubbo.simpledubbo.register.InMemoryRegister;
import org.warless.incubator.dubbo.simpledubbo.register.RemoteRegister;
import org.warless.incubator.simpledubbo.test.service.HelloService;
import org.warless.incubator.simpledubbo.test.service.impl.HelloServiceImpl;

import java.net.MalformedURLException;

/**
 * @date : 2019-09-16
 */
public class MainTest {

    @Test
    public void Provider() throws MalformedURLException {
        // 本地注册
        InMemoryRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);
        // 远程注册
        URL url = new URL("localhost", 8080);
        RemoteRegister.regist(HelloService.class.getName(), url);

        // 启动Tomcat
        HttpServer server = new HttpServer();
        server.start("localhost", 20880);
    }


    @Test
    public void Consumer() {

    }

}
