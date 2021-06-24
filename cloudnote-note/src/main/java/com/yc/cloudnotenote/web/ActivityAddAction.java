package com.yc.cloudnotenote.web;

import com.yc.cloudnote.bean.Activity;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnotenote.biz.ActivityBiz;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author:
 * @create: 2021-06-15 21:24
 */
@RestController
public class ActivityAddAction {
    @Resource
    private ActivityBiz activityBiz;

    @RequestMapping(value = "addActivity",method = {RequestMethod.GET,RequestMethod.POST})
    public Result AddActivity(Activity activity, HttpServletRequest request){

        activity.setActivitytitle(request.getParameter("title"));
        activity.setActivitybody(request.getParameter("body"));
//        String time = request.getParameter("begtime");
//        System.out.println(time);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date begtime = null;
//        Date endtime = null;
//        try {
//            begtime = dateFormat.parse(request.getParameter("begtime"));
//            endtime = dateFormat.parse(request.getParameter("begtime"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        activity.setActivitybegtime(new Timestamp(begtime.getTime()));
//        activity.setActivityendtime(new Timestamp(begtime.getTime()));
        //activity.s
        System.out.println("前端测试："+activity);
        Result result = Result.success("success",activityBiz.addActive(activity));
        return result;
    }
}
