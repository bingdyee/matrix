package io.hikari.transaction.account;

import io.hikari.transaction.core.annotation.DataSourceAspectSupport;
import io.hikari.transaction.core.annotation.GlobalTransactionAspectSupport;
import io.hikari.transaction.core.tm.FeignClientInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@EnableFeignClients(defaultConfiguration = FeignClientInterceptor.class)
@SpringBootApplication
public class AccountApplication {

    @Bean
    public GlobalTransactionAspectSupport astraTransactionAspectSupport() {
        return new GlobalTransactionAspectSupport();
    }

    @Bean
    public DataSourceAspectSupport dataSourceAspectSupport() {
        return new DataSourceAspectSupport();
    }


    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

}

