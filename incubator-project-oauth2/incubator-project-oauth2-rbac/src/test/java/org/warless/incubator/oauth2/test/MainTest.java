package org.warless.incubator.oauth2.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.warless.incubator.oauth2.rbac.mapper.UserMapper;

/**
 * @author yubb
 * @date 2019-08-20
 */
@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    @Mock
    private UserMapper userMapper;

    @Test
    public void one() {
        Mockito.when(userMapper.selectUserByUsername("Tom")).thenReturn(null);
        System.err.println();
    }

}
