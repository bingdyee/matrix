package org.warless.incubator.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.warless.incubator.webapp.ws.server.WebSocketChannelHandler;
import org.warless.incubator.webapp.ws.server.WebSocketServer;

@SpringBootApplication
public class WebApplication {

    @Bean
    public WebSocketServer webSocketServer() {
        WebSocketServer webSocketServer = new WebSocketServer(8089);
        webSocketServer.start(new WebSocketChannelHandler());
        return webSocketServer;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
