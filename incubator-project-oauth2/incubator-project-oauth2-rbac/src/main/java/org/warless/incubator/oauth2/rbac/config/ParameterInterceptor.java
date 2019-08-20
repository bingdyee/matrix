package org.warless.incubator.oauth2.rbac.config;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.warless.incubator.common.Constants;
import org.warless.incubator.common.utils.SnowflakeWorker;
import org.warless.incubator.oauth2.rbac.pojo.po.BaseEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Entity common properties setter
 *
 * @author : yubb
 * @date : 2019-08-06
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
        if (args[1] instanceof Map) {
            Map paramMap = (Map) args[1];
            for (Object obj : paramMap.values()) {
                if (obj instanceof List) {
                    ((List) obj).forEach(o -> setProperties(o, commandType));
                } else {
                    setProperties(obj, commandType);
                }
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) { }

    private void setProperties(Object obj, SqlCommandType commandType) {
        Date now = new Date();
        if (obj instanceof BaseEntity) {
            ((BaseEntity) obj).setUpdateTime(now);
            if (SqlCommandType.INSERT.equals(commandType)) {
                if (((BaseEntity) obj).getId() == null) {
                    ((BaseEntity) obj).setId(SnowflakeWorker.nextId());
                }
                if (((BaseEntity) obj).getCreateTime() == null) {
                    ((BaseEntity) obj).setCreateTime(now);
                }
                ((BaseEntity) obj).setHasDeleted(Constants.DELETE_STATUS_NORMAL);
            }
        }
    }

}
