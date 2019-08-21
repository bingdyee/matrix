package org.warless.incubator.oauth2.sso.config;


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
 * @date 2019-08-07
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
//                .antMatchers(HttpMethod.POST, "/api/v1/main").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/api/v1/main").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/api/v1/main").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.GET, "/api/v1/main").hasAnyAuthority("ADMIN", "USER")
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
