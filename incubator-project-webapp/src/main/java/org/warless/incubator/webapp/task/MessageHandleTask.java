package org.warless.incubator.webapp.task;

import com.alibaba.fastjson.JSON;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.warless.incubator.webapp.ws.pojo.MessageVO;
import org.warless.incubator.webapp.ws.pojo.ResponseBody;
import org.warless.incubator.webapp.ws.server.ConnectionPool;
import java.util.Date;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-13
 */
@Component
public class MessageHandleTask {

    private static final Logger logger = LoggerFactory.getLogger(MessageHandleTask.class);

    @Scheduled(fixedRate = 1000)
    public void task() {
        ConnectionPool.CLIENT_POOL.forEach((id, channel) -> {
            MessageVO message = new MessageVO();
            message.setId(id)
                    .setName("Noa Swartz")
                    .setAge(18)
                    .setBirth(new Date())
                    .setEmail("fetaxyu@gmal.com");
            String data = JSON.toJSONString(ResponseBody.success(message));
            logger.info("Send Message To {}: {}", id, data);
            channel.writeAndFlush(new TextWebSocketFrame(data));
        });
    }

}
