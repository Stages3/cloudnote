package com.yc.cloudnotenote.controller;

import com.yc.cloudnote.bean.Note;
import com.yc.cloudnote.bean.Share;
import com.yc.cloudnote.bean.User;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnotenote.dao.IShareMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ShareController {
    @Resource
    private IShareMapper shareMapper;

    /**
     * 通过用户id查询个人收藏夹
     * @param share
     * @return
     */
    @RequestMapping(value = "findbyuserid",method = {RequestMethod.POST,RequestMethod.GET})
    public Result findbyuserid(Share share){
        List<Share> list=shareMapper.findbyuserid(share.getUserid());
        return Result.success("success",list);
    }

    /**
     *
     * @param share
     * @return
     */
    @RequestMapping (value = "deleteShareByNoteId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result deleteShareByNoteId(Share share){
        int result=shareMapper.deleteShareByNoteId(share.getNoteid());
        Result res=Result.success("success",result);
        return res;
    }
}
