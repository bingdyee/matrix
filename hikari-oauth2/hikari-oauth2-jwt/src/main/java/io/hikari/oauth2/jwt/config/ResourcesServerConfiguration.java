package io.hikari.oauth2.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@Configuration
@EnableResourceServer
public class ResourcesServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("main").tokenStore(new JwtTokenStore(jwtAccessTokenConverter())).stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/main").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/main").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/main").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/main").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/oauth/token")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("client");
        return converter;
    }

}
