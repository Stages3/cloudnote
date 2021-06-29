package com.yc.cloudnotenote.controller;

import com.yc.cloudnote.bean.Notebook;
import com.yc.cloudnote.bean.User;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnotenote.dao.INoteBookMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping()
public class NoteBookController {

    @Resource
    private INoteBookMapper dao;

    /**
     * 通过用户id查询笔记本
     * @param nb
     * @param loginedUser
     * @return
     */
//    @RequestMapping(value="selectByUserId",method = {RequestMethod.POST,RequestMethod.GET})
//    public Result selectByUserId(Notebook nb, @SessionAttribute(required = false)User loginedUser){
//        List<Notebook> list=dao.selectByUserId(loginedUser.getUserid());
//        Result res=Result.success("success",list);
//        return res;
//    }

    /**
     * 通过用户id查询笔记本
     * @param nb
     * @return
     */
    @RequestMapping(value="selectByUserId1",method = {RequestMethod.POST,RequestMethod.GET})
    public Result selectByUserId1(Notebook nb){
        List<Notebook> list=dao.selectByUserId(nb.getUserid());
        Result res=Result.success("success",list);
        return res;
    }

    /**
     * 查询所有笔记本
     * @return
     */
    @RequestMapping(value = "findAllNoteBook",method = {RequestMethod.POST,RequestMethod.GET})
    public Result findAllNoteBook(){
        List<Notebook> list= dao.findAllNoteBook();
        Result res=Result.success("success",list);
        return res;
    }

    /**
     *添加笔记本
     * @param nb
     * @param
     * @return
     */
    @RequestMapping(value = "insertNoteBook",method = {RequestMethod.POST,RequestMethod.GET})
    public Result insert(Notebook nb, HttpServletRequest request){
        Cookie [] cookies=request.getCookies();
        if(cookies!=null){
//            Arrays.stream(cookies)
//                    .map(c -> c.getName() + "=" + c.getValue())
//                    .collect(Collectors.joining(", "));
            for(Cookie c:cookies){
                if(c.getName().equals("userId")){
                    nb.setUserid(Integer.parseInt(c.getValue()));
                }
            }
        }
        Result res=Result.success("success",dao.insert(nb));
        return res;

    }

    /**
     * 删除笔记本
     * @param nb
     * @param request
     * @return
     */
    @RequestMapping (value = "deleteNotebookById",method = {RequestMethod.POST,RequestMethod.GET})
    public Result deleteNotebookById(Notebook nb,HttpServletRequest request){
        int result=dao.deleteNotebookById(nb.getNotebookid());
        Result res=Result.success("success",result);
        return res;
    }

    /**
     * 更新笔记本状态
     * @param nb
     * @return
     */
    @RequestMapping (value = "updatestatus",method = {RequestMethod.POST,RequestMethod.GET})
    public Result updatestatus(Notebook nb){
        nb.setNotebookstatus(1);
        int result=dao.updatestatus(nb);
        Result res=Result.success("success",result);
        return res;
    }

    /**
     *
     * @param nb
     * @return
     */
    @RequestMapping (value = "updatestatus1",method = {RequestMethod.POST,RequestMethod.GET})
    public Result updatestatus1(Notebook nb){
        nb.setNotebookstatus(0);
        int result=dao.updatestatus(nb);
        Result res=Result.success("success",result);
        return res;
    }


}
