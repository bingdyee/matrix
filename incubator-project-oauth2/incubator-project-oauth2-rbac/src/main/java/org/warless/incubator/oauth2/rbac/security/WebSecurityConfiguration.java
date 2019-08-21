package org.warless.incubator.oauth2.rbac.security;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.warless.incubator.common.ResponseEntity;

import javax.sql.DataSource;
import java.util.Arrays;

import static org.springframework.security.config.Elements.REMEMBER_ME;

/**
 * @author fetaxyu
 * @date 2019-08-19
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * CORS
     *
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowedMethods(Arrays.asList("POST", "GET", "DELETE", "PUT", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/swagger-resources/**",
                "/webjars/**",
                "/v2/**",
                "/swagger-ui.html/**"
        );
    }

    /**
     * http安全配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .formLogin()
                .loginProcessingUrl("/api/user/login")
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutUrl("/api/user/logout")
                .logoutSuccessHandler(logoutSuccessHandler())
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .rememberMe()
                .rememberMeServices(rememberMeServices())
                .and().csrf().disable();
    }

    @Bean
    public RememberMeServices rememberMeServices() {
        JdbcTokenRepositoryImpl rememberMeTokenRepository = new JdbcTokenRepositoryImpl();
        rememberMeTokenRepository.setDataSource(dataSource);
        PersistentTokenBasedRememberMeServices rememberMeServices =
                new PersistentTokenBasedRememberMeServices(REMEMBER_ME, userDetailsService, rememberMeTokenRepository);
        rememberMeServices.setParameter(REMEMBER_ME);
        rememberMeServices.setTokenValiditySeconds(1209600);
        return rememberMeServices;
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, authentication) -> {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter()
                    .write(JSONObject.toJSONString(ResponseEntity.ok(authentication.getPrincipal())));
        };
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return (request, response, e) -> {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter()
                    .write(JSONObject.toJSONString(ResponseEntity.error("Login Failed!")));
        };
    }
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter()
                    .write(JSONObject.toJSONString(ResponseEntity.ok(null, "Logout Succeed!")));
        };
    }

}
