package com.yc.cloudnotenote.dao;

import com.yc.cloudnote.bean.Activitydetail;
import com.yc.cloudnote.bean.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IActivityDetailMapper {

    @Select("select * from activitydetail where activityid=#{activityid}")
    List<Activitydetail> selectByActivityId(int activityid);

    @Select("select * from activitydetail where noteid=#{noteid}")
    List<Activitydetail> selectByNoteId(int noteid);

    @Insert("insert into activitydetail values(default,#{activityid},#{userid},#{username},#{noteid},#{noteactivityup},#{noteactivitydown},#{noteactivitytitle},#{noteactivitybody},#{noteactivitystatus})")
    @Options(useGeneratedKeys = true,keyColumn = "noteactivityid",keyProperty = "noteactivityid")
    int insert(Activitydetail activitydetail);

    @Update("update activitydetail set noteactivitystatus=#{noteactivitystatus} where noteactivityid=#{noteactivityid}")
    int update(Activitydetail activitydetail);

    @Update("update activitydetail set noteactivityup=noteactivityup+1 where noteactivityid=#{noteactivityid}")
    int updateup(Activitydetail activitydetail);

    @Update("update activitydetail set noteactivitydown=noteactivitydown+1 where noteactivityid=#{noteactivityid}")
    int updatedown(Activitydetail activitydetail);
}
