package com.yc.cloudnote.bean;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:  活动表
 * @author:
 * @create: 2021-06-05 16:35
 */
@Data
@Table
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  //设置自增
    private Integer activityid;   //活动ID
    private String activitytitle; //活动标题
    private String activitybody;  //活动介绍(html片段)
    private Timestamp activityendtime; //活动结束时间
    private Timestamp activitybegtime; //活动开始时间
    private Integer activitystatus; //互动状态012未开始，进行中，结束

    @Transient
    private String deliverytimeString;   //给页面用的 VO中界面的参数类型

    public Timestamp getDeliveryTime(){
        Date d = null;
        if(deliverytimeString !=null ){
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                d = df.parse(deliverytimeString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            activityendtime = new Timestamp(d.getTime());
        } else{
            d = new Date();
        }
        activityendtime = new Timestamp(d.getTime());
        return this.activityendtime;
    }
}
