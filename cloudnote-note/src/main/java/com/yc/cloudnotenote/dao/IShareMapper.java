package com.yc.cloudnotenote.dao;


import com.yc.cloudnote.bean.Share;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface IShareMapper {

    @Insert("insert into share values(default, #{sharetitle},null,#{noteid},#{userid})")
    @Options(useGeneratedKeys = true,keyColumn = "shareid",keyProperty = "shareid")
    int share(Share share);


    @Select("select * from share where userid=#{userid}")
    List<Share> findbyuserid(int userid);

    @Delete("delete from share where noteid=#{noteid}")
    int deleteShareByNoteId(int noteid);


}
