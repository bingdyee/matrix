package io.hikari.elasticsearch.repository;

import io.hikari.elasticsearch.SpringIntegrationTest;
import io.hikari.elasticsearch.pojo.Paper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Noa Swartz
 * @date 2020-04-11
 */
public class PaperESRepositoryTest extends SpringIntegrationTest {

    @Autowired
    private PaperESRepository paperESRepository;

    @Test
    public void testCreateDocument() throws IOException {
        Paper paper = new Paper(2L,"Why the need for qPCR publication guidelines?—The case for MIQE", "10.1016/j.ymeth.2009.12.006", "https://qpcrupdate.info/bustin-the-case-of-miqe-2010.pdf");
        paperESRepository.save(paper);
        Optional<Paper> result = paperESRepository.findById(1L);
        result.ifPresent(value -> Assert.assertEquals(value.getDoi(), paper.getDoi()));
    }

}
