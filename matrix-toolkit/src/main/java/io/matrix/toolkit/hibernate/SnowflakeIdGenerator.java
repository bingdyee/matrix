package io.matrix.toolkit.hibernate;

import io.matrix.toolkit.util.SnowflakeWorker;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * @author Noa Swartz
 * @date 2020/08/17
 */
public class SnowflakeIdGenerator extends IdentityGenerator {

    public static final String NAME = "snowflakeIdGenerator";

    /** fully-qualified name */
    public static final String CANONICAL_NAME = "io.matrix.toolkit.hibernate.SnowflakeIdGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws MappingException {
        return SnowflakeWorker.nextId();
    }

}
