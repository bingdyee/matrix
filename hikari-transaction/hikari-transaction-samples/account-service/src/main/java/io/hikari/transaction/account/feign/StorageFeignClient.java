package io.hikari.transaction.account.feign;

import io.hikari.transaction.account.pojo.dto.CommodityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@FeignClient(name="storage", url = "http://127.0.0.1:8083/api/v1/storage")
public interface StorageFeignClient {

    /**
     * deduct storage count
     *
     * @param commodity CommodityDTO
     */
    @PutMapping
    void deduct(@RequestBody CommodityDTO commodity);

}
