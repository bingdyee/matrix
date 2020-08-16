package io.vbintx.phorcys.support;

import io.vbintx.phorcys.annotation.EnableAutoLog;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Noa Swartz
 */
public class AutoLogImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableAutoLog.class.getName()));
        if (annoAttrs != null) {
            return new String[] { AutoLogAspectSupport.class.getName() };
        }
        return new String[0];
    }

}