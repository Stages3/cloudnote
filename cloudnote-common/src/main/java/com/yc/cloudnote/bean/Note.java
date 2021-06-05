package com.yc.cloudnote.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:  笔记表
 * @author:
 * @create: 2021-06-05 16:35
 */
@Data
@Table
@Entity
public class Note {
    @Id
    private Integer noteid;             // '笔记ID',
    private Integer notebookid;         //'笔记本ID',
    private Integer userid;             //'用户ID',
    private Integer notestatus;         //'笔记状态ID:备用',
    private Integer notetype;           //'笔记本类型ID：备用',
    private String notetitle;           //'笔记标题',
    private String notebody;            //'笔记内容',
    private Long notecreatetime;        //'笔记创建时间',
    private Long notelastmodifytime;    //'笔记最近修改时间',
}
