package io.hikari.transaction.storage.service;

import io.hikari.transaction.storage.pojo.dto.CommodityDTO;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public interface StorageService {

    /**
     * 扣减库存
     *
     * @param commodityDTO
     */
    void decreaseStorage(CommodityDTO commodityDTO);

}
