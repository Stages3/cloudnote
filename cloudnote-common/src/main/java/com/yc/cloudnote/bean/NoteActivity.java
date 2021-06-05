package com.yc.cloudnote.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:  活动投稿表
 * @author:
 * @create: 2021-06-05 16:33
 */
@Data
@Table
@Entity
public class NoteActivity {
    @Id
    private Integer noteactivityid;       //'投稿ID',
    private Integer activityid;           //'活动ID',
    private Integer noteid;               //'笔记ID',
    private Integer noteactivityup;       //'投稿赞:增加数',
    private Integer noteactivitydown;     //'投稿踩:增加数',
    private String noteactivitytitle;     //
    private String noteactivitybody;      //
    private Integer noteactivitystatus;   //'0123各表示四种状态',
}
