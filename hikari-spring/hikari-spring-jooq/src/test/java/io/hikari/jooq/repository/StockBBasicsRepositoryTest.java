package io.hikari.jooq.repository;

import io.hikari.jooq.JooqApplication;
import io.hikari.jooq.pojo.po.StockBasicsPO;
import io.hikari.jooq.pojo.po.SysUserPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.groups.ConvertGroup;
import java.util.Date;

/**
 * @author Noa Swartz
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JooqApplication.class)
//@Transactional
//@Rollback
public class StockBBasicsRepositoryTest {

    @Autowired
    private StockBasicsRepository stockBasicsRepository;

    @Test
    public void testInsert() {
        stockBasicsRepository.findAll().forEach(System.err::println);
    }

    @Test
    public void testPage() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<StockBasicsPO> rs = stockBasicsRepository.listStockBasics(null, pageable);
        System.err.println(rs);
    }

}
