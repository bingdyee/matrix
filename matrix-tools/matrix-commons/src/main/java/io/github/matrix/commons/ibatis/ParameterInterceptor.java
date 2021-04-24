package io.github.matrix.commons.ibatis;

import io.github.matrix.commons.model.entity.Entity;
import io.github.matrix.commons.util.SnowflakeWorker;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.util.Collection;
import java.util.Properties;


/**
 * @author Bing D. Yee
 * @since 2021/04/05
 */
@Intercepts({@Signature(
        type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}
)})
public class ParameterInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        SqlCommandType commandType = mappedStatement.getSqlCommandType();
        Object parameter = args[1];
        if (SqlCommandType.INSERT.equals(commandType)) {
            if (parameter instanceof Entity) {
                setProperties(parameter);
            } else if (parameter instanceof Collection) {
                Collection<?> objects = (Collection<?>) parameter;
                for (Object obj : objects) {
                    if (!obj.getClass().isAssignableFrom(Entity.class)) {
                        break;
                    }
                    setProperties(parameter);
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {}

    private void setProperties(Object obj) {
        ((Entity) obj).setId(SnowflakeWorker.nextId());
    }

}
