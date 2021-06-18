package com.yc.cloudnotenote.dao;

import com.yc.cloudnote.bean.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IActivityMapper {

    @Select("select * from activity")
    List<Activity> findAllActivity();

    @Select("select * from activity where activityid=#{activityid}")
    List<Activity> findByActivityid(int activityid);
}
