package io.hikari.jooq.repository;

import io.hikari.jooq.JooqApplication;
import io.hikari.jooq.pojo.po.UserPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Noa Swartz
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JooqApplication.class)
@Transactional
@Rollback
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testInsert() {
        UserPO user = new UserPO();
        user.setId(98L);
        userRepository.insert(user);
    }

}
