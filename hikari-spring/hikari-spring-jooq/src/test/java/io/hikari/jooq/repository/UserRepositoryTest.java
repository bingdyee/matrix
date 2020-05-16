package io.hikari.jooq.repository;

import io.hikari.jooq.JooqApplication;
import io.hikari.jooq.pojo.po.SysUserPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Noa Swartz
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JooqApplication.class)
//@Transactional
//@Rollback
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testInsert() {
        SysUserPO user = new SysUserPO();
        user.setId(98L);
        user.setUsername("Noa");
        user.setPassword("123456");
        user.setDelFlag(false);
        user.setStatus(0);
        user.setCreateTime(new Date());
        userRepository.logicDeleteById(98L);
    }

}
