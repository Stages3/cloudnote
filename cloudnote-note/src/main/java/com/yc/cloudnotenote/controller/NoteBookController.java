package com.yc.cloudnotenote.controller;

import com.yc.cloudnote.bean.Notebook;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnotenote.dao.INoteBookMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
//@RequestMapping()
public class NoteBookController {

    @Resource
    private INoteBookMapper dao;

    @RequestMapping(value="selectByUserId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result selectByUserId(Notebook nb, HttpSession session){
        List<Notebook> list=dao.selectByUserId(nb.getUserid());
        Result res=Result.success("success",list);
        return res;
    }



    @RequestMapping(value = "findAllNoteBook",method = {RequestMethod.POST,RequestMethod.GET})
    public Result findAllNoteBook(){
        List<Notebook> list= dao.findAllNoteBook();
        Result res=Result.success("success",list);
        return res;
    }

    @RequestMapping(value = "insertNoteBook",method = {RequestMethod.POST,RequestMethod.GET})
    public Result insert(Notebook nb, HttpServletRequest request,HttpSession session){
        ServletContext application =session.getServletContext();

        int userid=Integer.parseInt(request.getParameter("userid"));
        String notebook_name=request.getParameter("notebookname");
        String notebook_desc=request.getParameter("notebookdesc");
        nb.setUserid(userid);
        nb.setNotebookname(notebook_name);
        nb.setNotebookdesc(notebook_desc);
//        System.out.println(userid+notebook_name);
//        System.out.println(application.getAttribute("notebookname"));
//        System.out.println(application.getAttribute("notebook_name"));
        Result res=Result.success("success",dao.insert(nb));
        return res;

    }

    @RequestMapping (value = "deleteNotebookById",method = {RequestMethod.POST,RequestMethod.GET})
    public Result deleteNotebookById(Notebook nb,HttpServletRequest request){

        int result=dao.deleteNotebookById(nb.getNotebookid());
        Result res=Result.success("success",result);
        return res;
    }


}