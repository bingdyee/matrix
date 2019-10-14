package org.warless.incubator.webapp.api;

import org.springframework.stereotype.Service;
import org.warless.incubator.webapp.ws.server.WebSocketChannelHandler;
import org.warless.incubator.webapp.ws.server.WebSocketServer;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-13
 */
@Service
public class CommonApi {

    private WebSocketServer server;

    public CommonApi() {
        server = new WebSocketServer(8089);
        server.start(new WebSocketChannelHandler());
    }

}
