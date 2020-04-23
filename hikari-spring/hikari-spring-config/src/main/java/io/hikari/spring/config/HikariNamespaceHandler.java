package io.hikari.spring.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.xml.sax.helpers.NamespaceSupport;

/**
 * @author Noa Swartz
 */
public class HikariNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("module", new HikariDefinitionParser());
    }

}
