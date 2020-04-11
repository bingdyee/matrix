package io.hikari.elasticsearch.repository;

import io.hikari.elasticsearch.pojo.Paper;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Not Add Like Or Between
 *
 * @author Noa Swartz
 * @date 2020-04-11
 */
@Repository
public interface PaperESRepository extends ElasticsearchRepository<Paper, Long> {
}
