package io.hikari.transaction.order;

import io.hikari.transaction.core.annotation.DataSourceAspectSupport;
import io.hikari.transaction.core.annotation.GlobalTransactionAspectSupport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@SpringBootApplication
public class OrderApplication {

    @Bean
    public GlobalTransactionAspectSupport astraTransactionAspectSupport() {
        return new GlobalTransactionAspectSupport();
    }

    @Bean
    public DataSourceAspectSupport dataSourceAspectSupport() {
        return new DataSourceAspectSupport();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
