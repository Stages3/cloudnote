package com.yc.cloudnotenote.web;

import com.yc.cloudnote.bean.Activity;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnotenote.biz.ActivityBiz;
import com.yc.cloudnotenote.dao.ActivityDao;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2021-06-15 21:24
 */
@RestController
public class ActivityAction {
    @Resource
    private ActivityBiz activityBiz;

    @Resource
    private ActivityDao dao;

    @RequestMapping(value = "addActivity",method = {RequestMethod.GET,RequestMethod.POST})
    public Result AddActivity(Activity activity, HttpServletRequest request){

        activity.setActivitytitle(request.getParameter("title"));
        activity.setActivitybody(request.getParameter("body"));
        activity.setActivitybegtime(activity.getDeliveryTime());
        System.out.println("前端测试："+activity);
        Result result = Result.success("success",activityBiz.addActive(activity));
        return result;
    }

    @RequestMapping(value = "findActivity",method = {RequestMethod.GET,RequestMethod.POST})
    public Result findActivity(HttpServletRequest request,Activity activity){
        String title = request.getParameter("title");
        activity = activityBiz.findByTitle(title);
        return Result.success("success",activity);
    }

    @RequestMapping(value = "findAllActivityback",method = {RequestMethod.GET,RequestMethod.POST})
    public Result findAll(Activity activity){
        List<Activity> list = dao.findAll(Example.of(activity));
        return Result.success("success",list);
    }

    @RequestMapping(value = "findDetailByAcId",method = {RequestMethod.GET,RequestMethod.POST})
    public Result findDetailByAcId(Activity activity, HttpSession session,Result rs){
        Activity ac = activityBiz.findActivityId(activity.getActivityid());
        session.setAttribute("ActivityById",ac);
        return Result.success("success",ac);
    }

}
