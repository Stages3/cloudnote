package com.yc.cloudnote.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:  分享表
 * @author:
 * @create: 2021-06-05 16:32
 */
@Data
@Table
@Entity
public class Share {
    @Id
    private Integer shareid;    //'共享ID',
    private String sharetitle;  //'共享标题',
    private String sharebody;   //'共享内容',
    private Integer noteid;     //'笔记id',
}
