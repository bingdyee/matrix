package io.hikari.spring.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @author Noa Swartz
 */
public class HikariDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Module.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        String module = element.getAttribute("module");
        if (name != null && !"".equals(name)) {
            builder.addPropertyValue("name", name);
        }
        if (module != null && !"".equals(module)) {
            builder.addPropertyValue("module", module);
        }
    }

}
