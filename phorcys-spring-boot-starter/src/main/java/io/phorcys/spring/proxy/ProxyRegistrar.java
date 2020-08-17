package io.phorcys.spring.proxy;

import io.phorcys.spring.annotation.ProxyScan;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Noa Swartz
 */
public class ProxyRegistrar implements ImportBeanDefinitionRegistrar {

    private static final String ATTR_NAME = "value";

    /**
     *
     * @param annotationMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(ProxyScan.class.getName()));
        List<String> basePackages = new ArrayList<>();
        for (String pkg : annoAttrs.getStringArray(ATTR_NAME)) {
            if (StringUtils.hasText(pkg)) {
                basePackages.addAll(Arrays.asList(StringUtils.tokenizeToStringArray(pkg, ",; \t\n")));
            }
        }
        ClassPathProxyScanner scanner = new ClassPathProxyScanner(registry, new DefaultResourceLoader());
        scanner.scanAndRegisterBean(StringUtils.toStringArray(basePackages));
    }
}