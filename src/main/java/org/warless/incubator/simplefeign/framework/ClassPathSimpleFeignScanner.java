package org.warless.incubator.simplefeign.framework;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.warless.incubator.simplefeign.annotations.FeignClient;

import java.io.IOException;

import static org.springframework.core.io.support.ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX;

/**
 * @author yubb
 * @date 2019-08-16
 */
public class ClassPathSimpleFeignScanner {

    private static final String FILE_PATTERN = "**/*.class";

    private BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    public ClassPathSimpleFeignScanner(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    public void scanAndRegisterBean(String... basePackages) {
        for (String basePackage : basePackages) {
            ResourceLoader resourceLoader = this.getResourceLoader();
            String packageSearchPath = CLASSPATH_ALL_URL_PREFIX + basePackage.replace(".", "/") + FILE_PATTERN;
            MetadataReaderFactory readerFactory = new SimpleMetadataReaderFactory(resourceLoader);
            try {
                Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(packageSearchPath);
                for (Resource resource : resources) {
                    MetadataReader reader = readerFactory.getMetadataReader(resource);
                    String className = reader.getClassMetadata().getClassName();
                    Class clazz = ClassUtils.forName(className, this.getClass().getClassLoader());
                    if (clazz.isInterface() && clazz.isAnnotationPresent(FeignClient.class)) {
                        this.registerBeanDefinition(clazz);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void registerBeanDefinition(Class clazz) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
        definition.getPropertyValues().add(FeignClientProxyFactory.INTERFACE_CLASS_VAR_NAME, definition.getBeanClassName());
        definition.setBeanClass(FeignClientProxyFactory.class);
        definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        this.registry.registerBeanDefinition(ClassUtils.getShortNameAsProperty(clazz), definition);
    }

    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    public void setRegistry(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


}
