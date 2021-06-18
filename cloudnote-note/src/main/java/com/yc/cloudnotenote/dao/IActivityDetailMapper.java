package com.yc.cloudnotenote.dao;

import com.yc.cloudnote.bean.Activitydetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IActivityDetailMapper {

    @Select("select * from activitydetail where activityid=#{activityid}")
    List<Activitydetail> selectByActivityId(int activityid);

    @Insert("insert into activitydetail values(default,#{activityid},#{userid},#{username},#{noteid},#{noteactivityup},#{noteactivitydown},#{noteactivitytitle},#{noteactivitybody},null)")
    @Options(useGeneratedKeys = true,keyColumn = "noteactivityid",keyProperty = "noteactivityid")
    int insert(Activitydetail activitydetail);
}
