package com.yc.cloudnote.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @description:  笔记本表
 * @author:
 * @create: 2021-06-05 16:32
 */
@Data
@Table
@Entity
public class Notebook {
    @Id
    private Integer notebookid;             //'笔记本ID',
    private Integer userid;                 //'用户ID',
    private String notebookname;            //'笔记本名',
    private String notebookdesc;            //'笔记本说明',
    private Timestamp notebookcreatetime;   //
}
