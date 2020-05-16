package io.hikari.common.jooq;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.UpdatableRecord;
import org.jooq.impl.DAOImpl;

import java.util.Collection;

/**
 * @author Noa Swartz
 */
public abstract class BaseRepository<R extends UpdatableRecord<R>, P, T> extends DAOImpl<R, P, T> {

    protected final DSLContext create;

    protected BaseRepository(Table<R> table, Class<P> type, Configuration configuration) {
        super (table, type, configuration);
        create = this.configuration().dsl();
    }

    @Override
    public T getId(P object) {
        return null;
    }

    /**
     * Deprecated: using optimistic lock
     *
     * @param object
     */
    @Deprecated
    @Override
    public final void update(P object) {
        super.update(object);
    }

    /**
     * Deprecated: using optimistic lock
     *
     * @param objects
     */
    @SafeVarargs
    @Deprecated
    @Override
    public final void update(P... objects) {
        super.update(objects);
    }

    /**
     * Deprecated: using optimistic lock
     *
     * @param objects
     */
    @Deprecated
    @Override
    public final void update(Collection<P> objects) {
        super.update(objects);
    }

    public int logicDeleteById(T id) {
      return 0;
    }

}
