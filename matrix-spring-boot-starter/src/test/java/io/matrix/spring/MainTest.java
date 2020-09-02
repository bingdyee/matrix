package io.matrix.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Phorcys Test
 *
 * @author Noa Swartz
 * @date 2020/08/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MatrixAutoConfiguration.class)
public class MainTest {

    @Test
    public void testRandom() {
    }

}
