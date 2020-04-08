package io.hikari.transaction.account.service;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
public interface AccountService {

    /**
     * purchase
     *
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    void purchase(Long userId, String commodityCode, int orderCount);

}
