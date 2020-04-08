package io.hikari.transaction.order.mapper;

import io.hikari.transaction.order.pojo.domain.OrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@Mapper
public interface OrderMapper {

    /**
     * 创建订单
     * @param  order 订单信息
     * @return int
     */
    int insert(@Param("order") OrderDO order);

}
