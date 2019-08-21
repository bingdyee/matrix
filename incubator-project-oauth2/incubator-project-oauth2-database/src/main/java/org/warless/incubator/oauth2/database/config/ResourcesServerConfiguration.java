package org.warless.incubator.oauth2.database.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.RequestMatcher;

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
        http.requestMatcher(authRequestMatcher())
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/main").hasAnyRole("ADMIN", "ROOT")
                .antMatchers(HttpMethod.DELETE, "/api/v1/main").hasAnyRole("ADMIN", "ROOT")
                .antMatchers(HttpMethod.PUT, "/api/v1/main").hasAnyRole("ADMIN", "ROOT")
                .antMatchers(HttpMethod.GET, "/api/v1/main").hasAnyRole("ADMIN", "USER", "ROOT")
                .antMatchers("/oauth/token")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    public RequestMatcher authRequestMatcher() {
        return request -> {
            if (request.getParameter(OAuth2AccessToken.ACCESS_TOKEN) != null) {
                return Boolean.TRUE;
            }
            String auth = request.getHeader("Authorization");
            return auth != null && auth.startsWith(OAuth2AccessToken.BEARER_TYPE);
        };
    }

}
