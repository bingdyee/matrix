package org.warless.incubator.sso.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.concurrent.TimeUnit;

/**
 * @author fetaxyu
 * @date 2019-08-21
 */
@SpringBootApplication
@EnableResourceServer
public class OAuth2SsoAuthServer {

    @Configuration
    @EnableAuthorizationServer
    public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        private TokenStore tokenStore;
        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        UserDetailsService userDetailsService;
        @Autowired
        private BCryptPasswordEncoder passwordEncoder;

        @Bean
        public TokenStore tokenStore() {
            return new InMemoryTokenStore();
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
            endpoints.authenticationManager(this.authenticationManager)
                    .userDetailsService(userDetailsService)
                    .tokenStore(tokenStore)
                    .tokenEnhancer((accessToken, authentication) -> accessToken);
            DefaultTokenServices tokenServices = (DefaultTokenServices) endpoints.getDefaultAuthorizationServerTokenServices();
            tokenServices.setTokenStore(endpoints.getTokenStore());
            tokenServices.setSupportRefreshToken(true);
            tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
            tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
            tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1));
            endpoints.tokenServices(tokenServices);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
            security.tokenKeyAccess("permitAll()")
                    .checkTokenAccess("isAuthenticated()")
                    .allowFormAuthenticationForClients();
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                    .withClient("client_1")
                    .secret(passwordEncoder.encode("secret_1"))
                    .authorizedGrantTypes("authorization_code", "refresh_token")
                    .scopes("all")
                    .autoApprove(true)
                    .redirectUris("http:/localhost:8081/")
                    .and()
                    .withClient("client_2")
                    .secret(passwordEncoder.encode("secret_2"))
                    .authorizedGrantTypes("authorization_code", "refresh_token")
                    .scopes("all")
                    .autoApprove(true)
                    .redirectUris("http:/localhost:8082/");
        }

    }


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

        @Bean
        @Override
        protected AuthenticationManager authenticationManager() throws Exception {
            return super.authenticationManager();
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers(
                    "/oauth/**", "/login", "/logout/**"
            );
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .requestMatchers()
                    .antMatchers("/oauth/**","/login","/home")
                    .and()
                    .authorizeRequests()
                    .antMatchers("/oauth/**").authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll();
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
            authenticationProvider.setUserDetailsService(userDetailsService());
            authenticationProvider.setPasswordEncoder(passwordEncoder());
            authenticationProvider.setHideUserNotFoundExceptions(false);
            return authenticationProvider;
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authenticationProvider());
        }


    }


    @RestController
    public class UserController {

        @GetMapping("/oauth/user-info")
        public Principal user(Principal principal) {
            return principal;
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(OAuth2SsoAuthServer.class, args);
    }

}
