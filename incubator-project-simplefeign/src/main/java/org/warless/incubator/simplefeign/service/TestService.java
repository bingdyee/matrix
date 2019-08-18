package org.warless.incubator.simplefeign.service;

import org.warless.incubator.simplefeign.annotations.FeignClient;
import org.warless.incubator.simplefeign.annotations.FeignRequest;
import org.warless.incubator.simplefeign.framework.FeignMethod;


/**
 * @author : yubb
 * @date : 2019-08-17
 */
@FeignClient("https://zujuan.21cnjy.com")
public interface TestService {

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
