package com.yc.cloudnotenote.controller;

import com.yc.cloudnote.bean.Activity;
import com.yc.cloudnote.bean.Activitydetail;
import com.yc.cloudnote.bean.Note;
import com.yc.cloudnotenote.dao.IActivityDetailMapper;
import com.yc.cloudnotenote.dao.INoteMapper;
import com.yc.cloudnote.enums.NoteStatusEnum;
import com.yc.cloudnote.vo.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ActivityDetailController {
    @Resource
    private IActivityDetailMapper detailMapper;

    @Resource
    private INoteMapper noteMapper;

    @RequestMapping(value = "selectByActivityId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result selectByActivityId(@SessionAttribute(required = false) Activity sendActivityid){
        List<Activitydetail> list=detailMapper.selectByActivityId(sendActivityid.getActivityid());
        Result res=Result.success("success",list);
        return res;
    }

    @RequestMapping(value = "shareByNoteId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result shareByNoteId(Note note, Activitydetail activitydetail){
        note.setNotestatus(NoteStatusEnum.FINISHED.getCode());
        noteMapper.update(note);
        activitydetail.setNoteactivitytitle(note.getNotetitle());
        activitydetail.setNoteactivitybody(note.getNotebody());
        int result=detailMapper.insert(activitydetail);
        Result res=Result.success("success",result);
        return res;
    }
}
