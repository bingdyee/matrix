package org.warless.incubator.oauth2.rbac.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.warless.incubator.common.utils.AES;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author : yubb
 * @date : 2019-08-10
 */
@Configuration
public class DruidDataSourceConfiguration {

    private static final String USERNAME_KEY = "Incubator_OAuth2_USERNAME";
    private static final String PASSWORD_KEY = "Incubator_OAuth2_PASSWORD";

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.max-active}")
    private int maxActive;
    @Value("${spring.datasource.initial-size}")
    private int initialSize;
    @Value("${spring.datasource.max-wait}")
    private long maxWait;
    @Value("${spring.datasource.min-idle}")
    private int minIdle;
    @Value("${spring.datasource.filters}")
    private String filters;
    @Value("${spring.datasource.validation-query}")
    private String validationQuery;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(AES.decrypt(username, USERNAME_KEY));
        dataSource.setPassword(AES.decrypt(password, PASSWORD_KEY));
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setMinIdle(minIdle);
        if (StringUtils.isNotBlank(validationQuery)) {
            dataSource.setValidationQuery(validationQuery);
        } else {
            DatabaseDriver databaseDriver = DatabaseDriver.fromJdbcUrl(url);
            String validationQuery = databaseDriver.getValidationQuery();
            if (StringUtils.isNotBlank(validationQuery)) {
                dataSource.setTestOnBorrow(true);
                dataSource.setValidationQuery(validationQuery);
            }
        }
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) { e.printStackTrace(); }
        return dataSource;
    }

    public static void main(String[] args) {
        String username = AES.encrypt("root", USERNAME_KEY);
        String password = AES.encrypt("root", PASSWORD_KEY);
        System.err.println("username: " + username);
        System.err.println("password: " + password);
    }

}
