package io.hikari.elasticsearch.repository;

import io.hikari.elasticsearch.SpringIntegrationTest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Noa Swartz
 * @date 2020-04-11
 */
public class RestHighLevelClientTest extends SpringIntegrationTest {

    public static final String INDEX_NAME = "hikari_es";

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void testCreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(INDEX_NAME);
        CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        Assert.assertEquals(response.index(), INDEX_NAME);
    }

    @Test
    public void testExistIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest(INDEX_NAME);
        boolean exist = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        Assert.assertTrue(exist);
    }

    @Test
    public void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(INDEX_NAME);
        AcknowledgedResponse response = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        Assert.assertTrue(response.isAcknowledged());
    }

}
