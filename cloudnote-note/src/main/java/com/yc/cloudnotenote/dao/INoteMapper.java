package com.yc.cloudnotenote.dao;

import com.yc.cloudnote.bean.Note;
import com.yc.cloudnote.bean.Notebook;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface INoteMapper {

    @Select("select * from note where notebookid = #{notebookid} ")
    List<Note> findBynotebookid(int notebookid);

    @Select("select * from note where noteid = #{noteid} ")
    List<Note> findByNoteid(int noteid);

    @Select("select * from note")
    List<Note> findAllNote();
//INSERT INTO note VALUES(NULL,1,1,0,0,"aaaa","aaaaaaaaaaaaa",NULL,NULL)
    @Insert("insert into note values(default,#{notebookid},#{userid},#{username},#{notestatus},#{notetype},#{notetitle},#{notebody},now(),#{notelastmodifytime})")
    @Options(useGeneratedKeys = true,keyColumn = "noteid",keyProperty = "noteid")
    int insert(Note note);

    //UPDATE notebook SET notebookname="ceshi" WHERE notebookid=1 ,notetitle=#{notetitle},notebody=#{notebody}
    @Update("update note set notestatus=#{notestatus} where noteid=#{noteid}")
    int update(Note note);

    //DELETE FROM note WHERE noteid=4 notebookid=#{notebookid}
    @Delete("delete from note where noteid=#{noteid}")
    int delete(int noteid);
}
