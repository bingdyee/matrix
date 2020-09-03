package io.matrix.spring;

import io.matrix.spring.boot.MatrixAutoConfiguration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * banner: http://patorjk.com/software/taag
 *
 * @author Noa Swartz
 * @date 2020/09/03
 */
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MatrixAutoConfiguration.class)
public class MatrixSpringBootStarterTest {

    @Test
    @Disabled("Context Load Test.")
    public void testLoadContext() {
        System.err.println("Succeed to load ApplicationContext.");
    }

}
