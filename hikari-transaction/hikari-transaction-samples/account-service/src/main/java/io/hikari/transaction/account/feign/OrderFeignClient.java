package io.hikari.transaction.account.feign;

import io.hikari.transaction.account.pojo.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@FeignClient(name = "order", url = "http://127.0.0.1:8082/api/v1/order")
public interface OrderFeignClient {


    /**
     * create order
     *
     * @param order
     * @return
     */
    @PostMapping
    OrderDTO create(@RequestBody OrderDTO order);

}
