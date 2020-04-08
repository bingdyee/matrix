package io.hikari.transaction.storage.controller;

import io.hikari.transaction.storage.pojo.dto.CommodityDTO;
import io.hikari.transaction.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Noa Swartz
 * @date 2020-04-04
 */
@RestController
@RequestMapping("/api/v1/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PutMapping
    public void deduct(@RequestBody CommodityDTO commodityDTO) {
        storageService.decreaseStorage(commodityDTO);
    }

}
