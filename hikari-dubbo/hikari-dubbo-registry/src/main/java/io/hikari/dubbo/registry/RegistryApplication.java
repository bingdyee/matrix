package io.hikari.dubbo.registry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @author Noa Swartz
 * @date 2020-04-07
 */
@SpringBootApplication
public class RegistryApplication {

    @Value("${embedded.zookeeper.port}")
    private int port;

    @PostConstruct
    public void startZooKeeperServer() {
        new EmbeddedZooKeeper(port, false).start();
    }

    public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class);
    }


}
