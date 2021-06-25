package com.yc.cloudnotenote.dao;

import com.yc.cloudnote.bean.Note;
import com.yc.cloudnote.bean.Share;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IShareMapper {

    @Insert("insert into share values(default, #{sharetitle},null,#{noteid})")
    @Options(useGeneratedKeys = true,keyColumn = "shareid",keyProperty = "shareid")
    int share(Share share);



}
