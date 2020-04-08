package io.hikari.transaction.storage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@Mapper
public interface StorageMapper {

    /**
     * 修改库存
     *
     * @param commodityCode 商品code
     * @param count 扣减数量
     * @return int
     */
    int updateStorage(@Param("commodityCode") String commodityCode, @Param("count") int count);

    /**
     * 查询剩余库存数量
     *
     * @param commodityCode
     * @return
     */
    int selectStorageCount(@Param("commodityCode") String commodityCode);

}
