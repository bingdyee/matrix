package io.github.matrix.workflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bing D. Yee
 * @since 2021/05/04
 */
@Configuration
public class AppConfigurer {

    final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        String[][] userInfos = {
                {"admin", "admin123", "USER_ADMIN", "GROUPS_ADMIN"},
                {"user", "user123", "USER_ADMIN", "GROUPS_MANAGER"},
                {"guest", "guest123", "USER_GUEST", "GROUPS_USER"}
        };
        for (String[] userInfo : userInfos) {
            List<SimpleGrantedAuthority> authorities = Arrays.asList(Arrays.copyOfRange(userInfo, 2, userInfo.length)).stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            inMemoryUserDetailsManager.createUser(new User(userInfo[0], passwordEncoder.encode(userInfo[1]), authorities));
        }

        return inMemoryUserDetailsManager;
    }

}
