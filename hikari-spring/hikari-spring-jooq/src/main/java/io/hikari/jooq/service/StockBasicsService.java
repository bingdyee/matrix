package io.hikari.jooq.service;

import io.hikari.common.util.BeanConverter;
import io.hikari.jooq.pojo.dto.StockBasicsDTO;
import io.hikari.jooq.pojo.po.StockBasicsPO;
import io.hikari.jooq.pojo.query.StockBasicsQuery;
import io.hikari.jooq.repository.StockBasicsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Noa Swartz
 */
@Service
public class StockBasicsService {

    private StockBasicsRepository stockBasicsRepository;

    public StockBasicsService(StockBasicsRepository stockBasicsRepository) {
        this.stockBasicsRepository = stockBasicsRepository;
    }

    public Page<StockBasicsDTO> listStockBasics(StockBasicsQuery query, Pageable pageable) {
        Page<StockBasicsPO> pd = stockBasicsRepository.listStockBasics(query, pageable);
        List<StockBasicsDTO> result = BeanConverter.convertList(pd.getContent(), StockBasicsDTO.class);
        return new PageImpl<>(result, PageRequest.of(pd.getNumber(), pd.getSize()), pd.getTotalElements());
    }

}
