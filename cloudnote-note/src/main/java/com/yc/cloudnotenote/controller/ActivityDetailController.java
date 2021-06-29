package com.yc.cloudnotenote.controller;

import com.yc.cloudnote.bean.Activity;
import com.yc.cloudnote.bean.Activitydetail;
import com.yc.cloudnote.bean.Note;
import com.yc.cloudnote.bean.Share;
import com.yc.cloudnotenote.dao.IActivityDetailMapper;
import com.yc.cloudnotenote.dao.INoteMapper;
import com.yc.cloudnote.enums.NoteStatusEnum;
import com.yc.cloudnote.vo.Result;

import com.yc.cloudnotenote.dao.IShareMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
public class ActivityDetailController {
    @Resource
    private IActivityDetailMapper detailMapper;

    @Resource
    private INoteMapper noteMapper;

    @Resource
    private IShareMapper ShapeMapper;

    /**
     * 通过session中的活动id查询活动
     * @param sendActivityid
     * @param session
     * @return
     */
    @RequestMapping(value = "selectByActivityId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result selectByActivityId(@SessionAttribute(required = false) Activity sendActivityid, HttpSession session){
        List<Activitydetail> list=detailMapper.selectByActivityId(sendActivityid.getActivityid());
        session.setAttribute("sendAcid",list.get(0));
        Result res=Result.success("success",list);
        return res;
    }

    /**
     * 通过活动详情表的活动id查询活动
     * @param activitydetail
     * @return
     */
    @RequestMapping(value = "selectByNoteActivityId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result selectByNoteActivityId(Activitydetail activitydetail){
        List<Activitydetail> list=detailMapper.selectByNoteActivityId(activitydetail.getNoteactivityid());
        Result res=Result.success("success",list);
        return res;
    }

    /**
     * 通过活动详情的笔记id查询note表中对应的笔记
     * @param activitydetail
     * @return
     */
    @RequestMapping(value = "selectByNoteId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result selectByNoteId(Activitydetail activitydetail){
        List<Activitydetail> list=detailMapper.selectByNoteId(activitydetail.getNoteid());
        Result res=Result.success("success",list);
        return res;
    }

    /**
     * 分享笔记：更新note表中笔记的状态为 审核中，
     *          活动详情表中添加对应数据
     * @param note
     * @param sendNoteid
     * @param sendActivityid
     * @param activitydetail
     * @param sendAcid
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "shareByNoteId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result shareByNoteId(Note note,@SessionAttribute(required = false) Note sendNoteid, @SessionAttribute(required = false) Activity sendActivityid,Activitydetail activitydetail, @SessionAttribute(required = false) Activitydetail sendAcid) throws IOException {
        activitydetail.setActivityid(sendActivityid.getActivityid());
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

    /**
     * 点赞
     * @param activitydetail
     * @return
     */
    @RequestMapping(value = "updateup",method = {RequestMethod.GET,RequestMethod.POST})
    public Result updateup(Activitydetail activitydetail){
        int result=detailMapper.updateup(activitydetail);
        Result res=Result.success("success",result);
        return res;
    }

    /**
     * 踩一踩
     * @param activitydetail
     * @return
     */
    @RequestMapping(value = "updatedown",method = {RequestMethod.GET,RequestMethod.POST})
    public Result updatedown(Activitydetail activitydetail){
        int result=detailMapper.updatedown(activitydetail);
        Result res=Result.success("success",result);
        return res;
    }

    /**
     * 收藏笔记：添加至默认收藏夹
     * @param share
     * @param sendNoteid
     * @return
     */
    @RequestMapping(value = "shoucang",method = {RequestMethod.GET,RequestMethod.POST})
    public Result shoucang(Share share,@SessionAttribute(required = false) Note sendNoteid){
        share.setSharetitle(sendNoteid.getNotetitle());
        share.setNoteid(sendNoteid.getNoteid());
        share.setUserid(sendNoteid.getUserid());
        int result=ShapeMapper.share(share);
        Result res=Result.success("success",result);
        return res;
    }
}
