package com.yc.cloudnotenote.controller;

import com.yc.cloudnote.bean.Note;
import com.yc.cloudnote.bean.Notebook;
import com.yc.cloudnote.enums.NoteStatusEnum;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnotenote.dao.INoteMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class NoteController {

    @Resource
    private INoteMapper dao;

    @RequestMapping(value="findBynotebookid",method = {RequestMethod.POST,RequestMethod.GET})
    public Result findBynotebookid(Note note,HttpSession session){
        List<Note> list=dao.findBynotebookid(note.getNotebookid());
        if(list.size()>0){
            session.setAttribute("sendNoteList",list.get(0));
        }else {
            Note nb=new Note();
            nb.setNotebookid(note.getNotebookid());
            list.add(0,nb);
            session.setAttribute("sendNoteList",list);
        }
        return Result.success("success",list);
    }

    @RequestMapping(value = "findByNoteid",method = {RequestMethod.POST,RequestMethod.GET})
    public Result findByNoteid(Note note,HttpSession session){
        List<Note> list=dao.findByNoteid(note.getNoteid());
        session.setAttribute("sendNoteid",list.get(0));
        return Result.success("success",list);
    }

    @RequestMapping(value = "findByNoteid1",method = {RequestMethod.POST,RequestMethod.GET})
    public Result findByNoteid1( @SessionAttribute(required = false)Note sendNoteid){
        List<Note> list=dao.findByNoteid(sendNoteid.getNoteid());
        return Result.success("success",list);
    }

    @RequestMapping("findAllNote")
    public Result findAllNoteBook(){
        List<Note> list= dao.findAllNote();
        Result res=Result.success("success",list);
        return res;
    }

    @RequestMapping(value = "insertNote",method = {RequestMethod.POST,RequestMethod.GET})
    public Result insert(Note nb, HttpServletResponse response, @SessionAttribute(required = false)Note sendNoteList) throws IOException {
        nb.setNotebookid(sendNoteList.getNotebookid());
        nb.setNotestatus(NoteStatusEnum.NEW.getCode());
        nb.setNotelastmodifytime(nb.getDeliverytime());
        Result res=Result.success("success",dao.insert(nb));
        if(res.getCode()==1){
            try {
                response.sendRedirect("http://127.0.0.1/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            response.sendError(0, res.getMsg());
        }
        return res;

    }

    @RequestMapping (value = "deleteNoteById",method = {RequestMethod.POST,RequestMethod.GET})
    public Result deleteNotebookById(Note n){
        int result=dao.delete(n.getNoteid());
        Result res=Result.success("success",result);
        return res;
    }

    @RequestMapping (value = "deleteByNoteBookId",method = {RequestMethod.POST,RequestMethod.GET})
    public Result deleteByNoteBookId(Note n){
        int result=dao.deleteByNoteBookId(n.getNotebookid());
        Result res=Result.success("success",result);
        return res;
    }
    @RequestMapping (value = "updateNote",method = {RequestMethod.POST,RequestMethod.GET})
    public Result updateNote(Note n, HttpServletResponse response) throws IOException {
        n.setNotelastmodifytime(n.getDeliverytime());
        int result=dao.deleteByNoteBookId(n.getNotebookid());
        Result res=Result.success("success",result);
        if(res.getCode()==1){
            try {
                response.sendRedirect("http://127.0.0.1/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            response.sendError(0, res.getMsg());
        }
        return res;
    }




}
