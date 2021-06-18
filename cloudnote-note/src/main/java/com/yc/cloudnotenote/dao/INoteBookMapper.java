package com.yc.cloudnotenote.dao;

import com.yc.cloudnote.bean.Notebook;
import com.yc.cloudnote.vo.Result;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface INoteBookMapper {

    //带一个参数查询
    @Select("select * from notebook where userid =  #{userid} ")
    List<Notebook> selectByUserId(int userid);

    @Select("select * from notebook")
    List<Notebook> findAllNoteBook();

//    @Select("SELECT * FROM notebook JOIN user ON  notebook.`userid`=user.`userid` where ")

    //INSERT INTO notebook VALUES(NULL,1,1,'测试3','aaaa','2021-06-04 20:09:16')
    @Insert("insert into notebook values(default,#{userid},#{notebookname},#{notebookdesc},now())")
    @Options(useGeneratedKeys = true,keyColumn = "notebookid",keyProperty = "notebookid")
    int insert(Notebook nb);

    //UPDATE notebook SET notebookname="ceshi" WHERE notebookid=1
    @Update("update notebook set notebookname=#{notebookname},notebookdesc=#{notebookdesc} where notebookid=#{notebookid}")
    int update(Notebook notebook);

    //DELETE FROM notebook WHERE notebookid=7
    @Delete("delete from notebook where notebookid=#{notebookid}")
    int deleteNotebookById(int notebookid);
}
