package com.yc.cloudnote.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:  用户表
 * @author:
 * @create: 2021-06-05 16:32
 */
@Data
@Table
@Entity
public class User {
    @Id
    private Integer userid;        //'用户ID',
    private String username;       //'用户名',
    private String userpassword;   //'密码',
    private String usertoken;      //'令牌',
    private String usernick;       //'说明',
    private String useremail;      //邮箱
    private Integer userstatus;    //用户账号状态
}
