package io.hikari.oauth2.rbac.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @author fetaxyu
 * @date 2019-08-19
 */
@Configuration
@EnableResourceServer
public class ResourcesServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "user";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/main").hasAuthority("main:insert")
                .antMatchers(HttpMethod.GET, "/api/v1/main").hasAuthority("main:select")
                .antMatchers(HttpMethod.PUT, "/api/v1/main").hasAuthority("main:update")
                .antMatchers(HttpMethod.DELETE, "/api/v1/main").hasAuthority("main:delete");
    }


}
