package io.hikari.transaction.order.service;

import io.hikari.transaction.order.pojo.dto.OrderDTO;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public interface OrderService {

    /**
     *  创建订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO createOrder(OrderDTO orderDTO);


}
