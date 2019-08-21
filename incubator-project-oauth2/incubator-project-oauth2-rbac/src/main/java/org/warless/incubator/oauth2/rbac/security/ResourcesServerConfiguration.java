package org.warless.incubator.oauth2.rbac.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @author yubb
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
        http.requestMatcher(requestMatcher())
                .authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    private RequestMatcher requestMatcher() {
        return request -> {
            if (request.getParameter(OAuth2AccessToken.ACCESS_TOKEN) != null) {
                return Boolean.TRUE;
            }
            String auth = request.getHeader("Authorization");
            return auth != null && auth.startsWith(OAuth2AccessToken.BEARER_TYPE);
        };
    }

}
