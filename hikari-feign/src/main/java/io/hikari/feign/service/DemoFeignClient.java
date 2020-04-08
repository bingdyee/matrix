package io.hikari.feign.service;

import io.hikari.feign.annotations.FeignClient;
import io.hikari.feign.annotations.FeignRequest;
import io.hikari.feign.framework.FeignMethod;

/**
 * @author Noa Swartz
 * @date 2020-04-08
 */
@FeignClient("https://zujuan.21cnjy.com")
public interface DemoFeignClient {

    /**
     *
     * 获取各年级题目
     *
     * @param xd
     * @param chid
     * @param page
     * @param categories
     * @return
     */
    @FeignRequest(value = "/api/question/list", method = FeignMethod.GET)
    Object listQuestion(int xd, int chid, int page, String categories);

}
