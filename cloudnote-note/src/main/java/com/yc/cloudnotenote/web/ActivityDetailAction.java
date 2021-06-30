package com.yc.cloudnotenote.web;

import com.yc.cloudnote.bean.Activity;
import com.yc.cloudnote.bean.Activitydetail;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnotenote.dao.ActivityDetailDao;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: 赵俊华
 * @create: 2021-06-26 20:28
 */
@RestController
public class ActivityDetailAction {
    @Resource
    private ActivityDetailDao detailDao;

    /**
     * 这个findDetailByID1是对接的ActivityAction的findDetailByAcId
     * @param
     * @return
     */
    @RequestMapping(value = "findDetailByAcId1",method = {RequestMethod.GET,RequestMethod.POST})
    public Result findDetailByActivityId(@SessionAttribute(required = false) Activity ActivityById){

        Activitydetail activitydetail1 = new Activitydetail();
        List<Activitydetail> list = null;
        activitydetail1.setActivityid( ActivityById.getActivityid());
        list = detailDao.findAll(Example.of(activitydetail1));
        //System.out.println("投稿测试："+list);
        return Result.success("success",list);
    }

    @RequestMapping(value = "findOneActivity",method = {RequestMethod.GET,RequestMethod.POST})
    public Result findByActivityId(@SessionAttribute(required = false) Activity ActivityById){

        Activity activity = ActivityById;

        return Result.success("success",activity);
    }
}
