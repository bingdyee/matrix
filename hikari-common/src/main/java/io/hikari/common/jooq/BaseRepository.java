package io.hikari.common.jooq;

import io.hikari.common.exception.InvalidDataAccessException;
import io.hikari.common.pojo.BasePO;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SortField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UpdatableRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Description:
 *
 * @author Noa Swartz
 */
public abstract class BaseRepository<R extends UpdatableRecord<R>, P extends BasePO, ID> {

    protected final DSLContext create;
    protected final Table<R> table;
    protected final Field<ID> idField;
    protected final Class<P> poClass;

    public BaseRepository(DSLContext dslContext, Table<R> table, Field<ID> idField, Class<P> poClass) {
        this.create = dslContext;
        this.table = table;
        this.poClass = poClass;
        this.idField = idField;
    }

    public P selectById(ID id) {
        TableField f = (TableField) table.field("del_flag");
        return create
                .select(table.fields())
                .from(table)
                .where(idField.eq(id))
                .and(f.eq(0))
                .fetchOneInto(poClass);
    }

    public int delete(ID id) {
       return this.create.delete(this.table).where(this.idField.eq(id)).execute();
    }

    public Page<P> selectPage(Pageable pageable, Collection<? extends Condition> condition) {
        long count = create.selectCount().from(table).where(condition).fetchOneInto(Long.class);
        if (count == 0L) {
            return new PageImpl<>(Collections.emptyList(), pageable, count);
        }
        System.err.println(pageable.getOffset());
        List<P> list = create.selectFrom(table)
                .where(condition)
                .orderBy(getSortFields(pageable.getSort()))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetchInto(poClass);
        return new PageImpl<>(list, pageable, count);
    }

    private Collection<SortField<?>> getSortFields(Sort sortSpecification) {
        Collection<SortField<?>> querySortFields = new ArrayList<>();
        if (sortSpecification == null) {
            return querySortFields;
        }
        Iterator<Sort.Order> specifiedFields = sortSpecification.iterator();
        while (specifiedFields.hasNext()) {
            Sort.Order specifiedField = specifiedFields.next();
            String sortFieldName = specifiedField.getProperty();
            Sort.Direction sortDirection = specifiedField.getDirection();
            Field tableField = table.field(sortFieldName);
            SortField<?> querySortField = sortDirection == Sort.Direction.ASC ? tableField.asc() : tableField.desc();
            querySortFields.add(querySortField);
        }
        return querySortFields;
    }

}
