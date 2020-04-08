package io.hikari.transaction.account.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@Mapper
public interface AccountMapper {

    /**
     * update user's amount
     *
     * @param id userId
     * @param amount amount
     * @return i
     */
    int updateAmountById(@Param("id") Long id, @Param("amount") BigDecimal amount);


    BigDecimal selectAmount(@Param("id") Long id);

}
