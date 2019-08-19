package org.warless.incubator.oauth2.database.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2 config
 *
 * @author : yubb
 * @date : 2019-08-06
 */
@EnableSwagger2
@Configuration
@ConditionalOnProperty(prefix = "swagger", value = {"enable"}, havingValue = "true")
public class SwaggerConfiguration {

    @Value("${swagger.api-info.title}")
    private String title;
    @Value("${swagger.api-info.description}")
    private String description;
    @Value("${swagger.api-info.url}")
    private String url;
    @Value("${swagger.api-info.version}")
    private String version;
    @Value("${swagger.api-info.author}")
    private String author;
    @Value("${swagger.api-info.email}")
    private String email;
    @Value("${swagger.api-info.contact}")
    private String contact;

    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact(author, contact, email))
                .title(title)
                .description(description)
                .termsOfServiceUrl(url)
                .version(version)
                .build();
    }

}
