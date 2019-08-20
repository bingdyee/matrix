package org.warless.incubator.oauth2.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.warless.incubator.oauth2.rbac.OAuth2Application;

/**
 * @author yubb
 * @date 2019-08-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= OAuth2Application.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OAuth2DatabaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void one() {

    }

}
