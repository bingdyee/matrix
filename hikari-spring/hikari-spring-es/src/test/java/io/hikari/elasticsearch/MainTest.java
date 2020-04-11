package io.hikari.elasticsearch;

import io.hikari.elasticsearch.repository.PaperESRepositoryTest;
import io.hikari.elasticsearch.repository.RestHighLevelClientTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Noa Swartz
 * @date 2020-04-11
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        PaperESRepositoryTest.class,
        RestHighLevelClientTest.class
})
public class MainTest {
}