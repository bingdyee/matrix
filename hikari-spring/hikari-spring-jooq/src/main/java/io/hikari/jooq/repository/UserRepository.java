package io.hikari.jooq.repository;

import io.hikari.common.jooq.BaseRepository;
import io.hikari.jooq.domain.Tables;
import io.hikari.jooq.domain.tables.records.SysUserRecord;
import io.hikari.jooq.pojo.po.SysUserPO;
import org.jooq.Configuration;
import org.springframework.stereotype.Repository;

import static io.hikari.jooq.domain.Tables.SYS_USER;

/**
 * @author Noa Swartz
 */
@Repository
public class UserRepository extends BaseRepository<SysUserRecord, SysUserPO, Long> {

    public UserRepository(Configuration configuration) {
        super(SYS_USER, SysUserPO.class, configuration);
    }

    @Override
    public int logicDeleteById(Long id) {
        return create.update(SYS_USER)
                .set(SYS_USER.DEL_FLAG, 1)
                .where(SYS_USER.ID.eq(id))
                .execute();
    }
}
