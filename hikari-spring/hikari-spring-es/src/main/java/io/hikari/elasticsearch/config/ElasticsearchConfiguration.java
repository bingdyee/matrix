package io.hikari.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Noa Swartz
 * @date 2020-04-11
 */
@Configuration
public class ElasticsearchConfiguration {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http"))
        );
    }

}
