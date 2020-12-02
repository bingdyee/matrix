package io.github.matrix.elastic;

import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.rest.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.elasticsearch.rest.RestRequest.Method.GET;

/**
 * @author Noa Swartz
 * @date 2020/12/01
 */
public class RestActionHandler extends BaseRestHandler {

    @Override
    public String getName() {
        return "rest_handler_cat_example";
    }

    @Override
    public List<Route> routes() {
        return Collections.singletonList(new Route(GET, "/_cat/example"));
    }

    @Override
    protected RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient nodeClient) throws IOException {
        return channel -> {
            channel.sendResponse(new BytesRestResponse(RestStatus.OK, "rest action example plugin"));
        };
    }

}
