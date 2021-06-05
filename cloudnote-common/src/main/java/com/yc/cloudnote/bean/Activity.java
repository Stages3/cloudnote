package com.yc.cloudnote.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private Integer activityid;   //活动ID
    private String activitytitle; //活动标题
    private String activitybody;  //活动介绍(html片段)
    private Long activityendtime; //活动结束时间
    private Long activitybegtime; //活动开始时间
    private Integer activitystatus; //互动状态012未开始，进行中，结束
}
