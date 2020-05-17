package io.hikari.jooq.controller;

import io.hikari.common.pojo.ResponseEntity;
import io.hikari.jooq.pojo.dto.StockBasicsDTO;
import io.hikari.jooq.pojo.query.StockBasicsQuery;
import io.hikari.jooq.service.StockBasicsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Noa Swartz
 */
@RestController
@RequestMapping("/api/stockBasics")
public class StockBasicsController {

    private StockBasicsService stockBasicsService;

    public StockBasicsController(StockBasicsService stockBasicsService) {
        this.stockBasicsService = stockBasicsService;
    }

    @GetMapping("/list")
    public Page<StockBasicsDTO> listStockBasics(StockBasicsQuery query, @PageableDefault(sort = {"id"}) Pageable pageable) {
        return stockBasicsService.listStockBasics(query, pageable);
    }


}
