package io.hikari.transaction.account.service.impl;

import io.hikari.transaction.account.feign.OrderFeignClient;
import io.hikari.transaction.account.feign.StorageFeignClient;
import io.hikari.transaction.account.mapper.AccountMapper;
import io.hikari.transaction.account.pojo.domain.AccountDO;
import io.hikari.transaction.account.pojo.dto.CommodityDTO;
import io.hikari.transaction.account.pojo.dto.OrderDTO;
import io.hikari.transaction.account.service.AccountService;
import io.hikari.transaction.core.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private OrderFeignClient orderFeignClient;
    @Autowired
    private StorageFeignClient storageFeignClient;
    @Autowired
    private AccountMapper accountMapper;

    @GlobalTransactional("account-order")
    @Override
    public void purchase(Long userId, String commodityCode, int orderCount) {
        CommodityDTO commodity = new CommodityDTO();
        commodity.setCount(orderCount);
        commodity.setCommodityCode(commodityCode);
        storageFeignClient.deduct(commodity);
        OrderDTO dto = new OrderDTO();
        dto.setCommodityCode(commodityCode);
        dto.setCount(orderCount);
        dto.setUserId(userId);
        OrderDTO order = orderFeignClient.create(dto);
        BigDecimal amount = accountMapper.selectAmount(userId);
        if (amount.compareTo(order.getAmount()) < 0) {
            throw new RuntimeException("余额不足！");
        }
        accountMapper.updateAmountById(userId, order.getAmount());
    }

}
