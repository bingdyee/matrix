package io.hikari.dubbo.api.serialize;

import io.hikari.dubbo.api.pojo.dto.DemoDTO;
import org.apache.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new ArrayList<>();
        classes.add(DemoDTO.class);
        return classes;
    }

}
