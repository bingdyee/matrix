package io.hikari.transaction.storage.service.impl;

import io.hikari.transaction.storage.mapper.StorageMapper;
import io.hikari.transaction.storage.pojo.dto.CommodityDTO;
import io.hikari.transaction.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void decreaseStorage(CommodityDTO commodityDTO) {
        int count = storageMapper.selectStorageCount(commodityDTO.getCommodityCode());
        if (count < commodityDTO.getCount()) {
            // 测试全局事务回滚
            throw new RuntimeException("库存不足！");
        }
        storageMapper.updateStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());
    }

}
