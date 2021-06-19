package com.yc.cloudnotenote.controller;

import com.yc.cloudnote.bean.Activity;
import com.yc.cloudnote.bean.Activitydetail;
import com.yc.cloudnote.bean.Note;
import com.yc.cloudnotenote.dao.IActivityDetailMapper;
import com.yc.cloudnotenote.dao.INoteMapper;
import com.yc.cloudnote.enums.NoteStatusEnum;
import com.yc.cloudnote.vo.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class ActivityDetailController {
    @Resource
    private IActivityDetailMapper detailMapper;

    @Resource
    private INoteMapper noteMapper;

    @RequestMapping(value = "selectByActivityId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result selectByActivityId(@SessionAttribute(required = false) Activity sendActivityid, HttpSession session){
        List<Activitydetail> list=detailMapper.selectByActivityId(sendActivityid.getActivityid());
        session.setAttribute("sendAcid",list.get(0));
        Result res=Result.success("success",list);
        return res;
    }
    @RequestMapping(value = "selectByNoteActivityId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result selectByNoteActivityId(Activitydetail activitydetail){
        List<Activitydetail> list=detailMapper.selectByNoteActivityId(activitydetail.getNoteactivityid());
        Result res=Result.success("success",list);
        return res;
    }

    @RequestMapping(value = "selectByNoteId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result selectByNoteId(Activitydetail activitydetail){
        List<Activitydetail> list=detailMapper.selectByNoteId(activitydetail.getNoteid());
        Result res=Result.success("success",list);
        return res;
    }

    @RequestMapping(value = "shareByNoteId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result shareByNoteId(Note note,@SessionAttribute(required = false) Note sendNoteid, Activitydetail activitydetail, @SessionAttribute(required = false) Activitydetail sendAcid) throws IOException {
        activitydetail.setActivityid(sendAcid.getActivityid());
        activitydetail.setNoteid(sendNoteid.getNoteid());
        activitydetail.setNoteactivitytitle(sendNoteid.getNotetitle());
        activitydetail.setNoteactivitystatus(NoteStatusEnum.NEW.getCode());
        activitydetail.setUserid(sendNoteid.getUserid());
        activitydetail.setUsername(sendNoteid.getUsername());
        activitydetail.setNoteactivityup(0);
        activitydetail.setNoteactivitydown(0);
        int result=detailMapper.insert(activitydetail);
        Result res=Result.success("success",result);
        if(res.getCode()==1){
            note.setNoteid(sendNoteid.getNoteid());
            note.setNotestatus(NoteStatusEnum.FINISHED.getCode());
            noteMapper.update(note);
        }
        return res;
    }

    @RequestMapping(value = "updateup",method = {RequestMethod.GET,RequestMethod.POST})
    public Result updateup(Activitydetail activitydetail){
        int result=detailMapper.updateup(activitydetail);
        Result res=Result.success("success",result);
        return res;
    }

    @RequestMapping(value = "updatedown",method = {RequestMethod.GET,RequestMethod.POST})
    public Result updatedown(Activitydetail activitydetail){
        int result=detailMapper.updatedown(activitydetail);
        Result res=Result.success("success",result);
        return res;
    }
}
