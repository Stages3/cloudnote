package com.yc.cloudnotenote.controller;

import com.yc.cloudnote.bean.Activity;
import com.yc.cloudnote.bean.Activitydetail;
import com.yc.cloudnote.bean.Note;
import com.yc.cloudnote.bean.Notebook;
import com.yc.cloudnotenote.dao.IActivityDetailMapper;
import com.yc.cloudnotenote.dao.IActivityMapper;
import com.yc.cloudnote.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
@RestController
public class ActivityController {

    @Resource
    private IActivityMapper activityMapper;

    @Resource
    private IActivityDetailMapper activityDetailMapper;

    @RequestMapping(value = "findAllActivity",method = {RequestMethod.POST,RequestMethod.GET})
    public Result findAllNoteBook(){
        List<Activity> list= activityMapper.findAllActivity();
        Result res=Result.success("success",list);
        return res;
    }

    @RequestMapping(value = "findByActivityid",method = {RequestMethod.POST,RequestMethod.GET})
    public Result findByActivityid(Activity activity,HttpSession session){

        List<Activity> list=activityMapper.findByActivityid(activity.getActivityid());
        if(list.size()>0){
            session.setAttribute("sendActivityid",list.get(0));
        }
        Result res=Result.success("success",list);
        return res;

    }
}
