package com.yc.cloudnotenote.web;

import com.yc.cloudnotenote.dao.ActivityDao;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: 赵俊华
 * @create: 2021-06-15 21:24
 */
@RestController
public class ActivityAddAction {
    @Resource
    private ActivityDao activityDao;

//    @RequestMapping
//    public Result AddActivity(){
//
//        Result result = Result.success();
//        return result;
//    }
}
