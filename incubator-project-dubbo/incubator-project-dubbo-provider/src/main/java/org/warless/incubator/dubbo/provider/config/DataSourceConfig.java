package org.warless.incubator.dubbo.provider.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.warless.incubator.common.utils.AES;

import javax.sql.DataSource;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-11
 */
@Configuration
public class DataSourceConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


}
