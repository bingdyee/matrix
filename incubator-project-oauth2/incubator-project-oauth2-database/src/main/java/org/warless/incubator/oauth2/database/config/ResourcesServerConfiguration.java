package org.warless.incubator.oauth2.database.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author yubb
 * @date 2019-08-19
 */
@Configuration
@EnableResourceServer
public class ResourcesServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("main").stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(request -> {
            if (request.getParameter(OAuth2AccessToken.ACCESS_TOKEN) != null) {
                return Boolean.TRUE;
            }
            String auth = request.getHeader("Authorization");
            return auth != null && auth.startsWith(OAuth2AccessToken.BEARER_TYPE);
        }).authorizeRequests()
                .antMatchers("/api/user/login",
                        "/api/user/logout",
                        "/oauth/token",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/**",
                        "/swagger-ui.html/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

}
