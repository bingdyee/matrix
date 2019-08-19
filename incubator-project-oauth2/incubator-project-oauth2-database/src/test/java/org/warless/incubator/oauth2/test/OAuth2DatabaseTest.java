package org.warless.incubator.oauth2.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.warless.incubator.oauth2.database.OAuth2DatabaseApplication;

/**
 * @author yubb
 * @date 2019-08-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= OAuth2DatabaseApplication.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OAuth2DatabaseTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void encodePassword() {
        String cryptText = bCryptPasswordEncoder.encode("system");
        System.err.println("Password: " + cryptText + " " + cryptText.length());
    }


}
