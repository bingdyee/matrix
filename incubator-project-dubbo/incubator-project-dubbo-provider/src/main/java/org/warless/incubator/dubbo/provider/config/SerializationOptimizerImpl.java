package org.warless.incubator.dubbo.provider.config;

import org.apache.dubbo.common.serialize.support.SerializationOptimizer;
import org.warless.incubator.dubbo.api.demo.pojo.dto.UserDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-10
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new ArrayList<>();
        classes.add(UserDTO.class);
        return classes;
    }

}
