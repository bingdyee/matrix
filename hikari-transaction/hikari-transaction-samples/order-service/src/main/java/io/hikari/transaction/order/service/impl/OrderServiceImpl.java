package io.hikari.transaction.order.service.impl;

import io.hikari.transaction.order.mapper.OrderMapper;
import io.hikari.transaction.order.pojo.domain.OrderDO;
import io.hikari.transaction.order.pojo.dto.OrderDTO;
import io.hikari.transaction.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        OrderDO order = new OrderDO();
        BeanUtils.copyProperties(orderDTO, order);

        order.setOrderNo(UUID.randomUUID().toString().replace("-",""));
        order.setId(System.currentTimeMillis());
        order.setAmount(BigDecimal.valueOf(199.9).multiply(BigDecimal.valueOf(orderDTO.getCount())));
        order.setCount(orderDTO.getCount());
        orderMapper.insert(order);

        orderDTO.setAmount(order.getAmount());
        orderDTO.setOrderNo(order.getOrderNo());
        return orderDTO;
    }

}
