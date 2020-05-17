package io.hikari.jooq.repository;

import io.hikari.common.jooq.BaseRepository;
import io.hikari.jooq.domain.tables.records.SysUserRecord;
import io.hikari.jooq.domain.tables.records.TbStockBasicsRecord;
import io.hikari.jooq.pojo.po.StockBasicsPO;
import io.hikari.jooq.pojo.po.SysUserPO;
import io.hikari.jooq.pojo.query.StockBasicsQuery;
import org.jooq.Configuration;
import org.jooq.Table;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static io.hikari.jooq.domain.Tables.TB_STOCK_BASICS;

/**
 * @author Noa Swartz
 */
@Repository
public class StockBasicsRepository extends BaseRepository<TbStockBasicsRecord, StockBasicsPO, Long> {

    protected StockBasicsRepository(Configuration configuration) {
        super(TB_STOCK_BASICS, StockBasicsPO.class, configuration);
    }

    public Page<StockBasicsPO> listStockBasics(StockBasicsQuery query, Pageable pageable) {
        List<StockBasicsPO> queryResults = create.selectFrom(TB_STOCK_BASICS)
                .orderBy(TB_STOCK_BASICS.ID)
                .limit(pageable.getPageSize()).offset((int)pageable.getOffset())
                .fetchInto(StockBasicsPO.class);
        long totalCount = create.fetchCount(create.select().from(TB_STOCK_BASICS));
        return new PageImpl<>(queryResults, pageable, totalCount);
    }
}
