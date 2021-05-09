package io.github.matrix.boot.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.github.matrix.boot.web.GlobalWebExceptionTranslator;
import io.github.matrix.boot.web.JacksonErrorController;
import io.github.matrix.commons.constant.Constants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.time.format.DateTimeFormatter;

/**
 * 统一Web配置
 *
 * @author yubinbin
 * @since 2021/04/09
 */
@Configuration
@ConditionalOnWebApplication
@Import({ GlobalWebExceptionTranslator.class, JacksonErrorController.class })
public class GlobalWebConfigurer {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilder() {
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT)))
                    .serializationInclusion(JsonInclude.Include.NON_NULL)
                    .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        };
    }

}
