package org.warless.incubator.oauth2.security.config;


import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.warless.incubator.common.ResponseEntity;

import static org.springframework.security.config.Elements.REMEMBER_ME;


/**
 *  WebSecurityConfiguration
 *
 * @author : fetaxyu
 * @date : 2019-08-06
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        BCryptPasswordEncoder encoder = passwordEncoder();
        manager.createUser(User.withUsername("admin").password(encoder.encode("123456")).authorities("ADMIN").build());
        manager.createUser(User.withUsername("user").password(encoder.encode("123456")).authorities("USER").build());
        return manager;
    }

    /**
     * 认证管理
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
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
                .logout().logoutUrl("/api/user/logout").logoutSuccessHandler(logoutSuccessHandler())
                .and()
                .rememberMe()
                .rememberMeServices(rememberMeServices())
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/main").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/main").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/main").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/main").hasAnyAuthority("ADMIN", "USER")
                .and().csrf().disable();
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

    @Bean
    public RememberMeServices rememberMeServices() {
        TokenBasedRememberMeServices rememberMeServices =
                new TokenBasedRememberMeServices(REMEMBER_ME, userDetailsService());
        rememberMeServices.setParameter(REMEMBER_ME);
        rememberMeServices.setTokenValiditySeconds(1209600);
        return rememberMeServices;
    }

}
