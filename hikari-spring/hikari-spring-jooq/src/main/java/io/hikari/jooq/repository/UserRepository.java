package io.hikari.jooq.repository;

import io.hikari.jooq.pojo.dto.UserDTO;
import io.hikari.jooq.pojo.po.UserPO;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static io.hikari.jooq.generated.tables.SysUser.SYS_USER;

/**
 * @author Noa Swartz
 */
@Repository
public class UserRepository {

    @Autowired
    DSLContext dslContext;

    public UserRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public int insert(UserPO user) {
        return dslContext.insertInto(SYS_USER)
                .columns(SYS_USER.ID)
                .values(user.getId())
                .execute();
    }

    public int update(UserDTO user) {
        return 1;
    }

    public UserDTO selectById(Long id) {
        return null;
    }

    public int deleteById(Long id) {
        return 1;
    }


}
