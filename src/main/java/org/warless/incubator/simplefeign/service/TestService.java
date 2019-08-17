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
    //xd=2&chid=3&page=1&_=1559377729668categories=${grade}
    //https://zujuan.21cnjy.com/api/question/list?xd=2&chid=3&categories=10166&knowledges=&question_channel_type=&difficult_index=&exam_type=1&kid_num=&grade_id=&sort_field=time&filterquestion=0&page=1&_grade_id=&tree_type=category&version_id=&_=1566005172531
}
