package com.yc.cloudnote.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @description:  用户表
 * @author:
 * @create: 2021-06-05 16:32
 */

@Data
@Table
@Entity
public class User implements Serializable {
    @Id
    private Integer userid;
    @NotEmpty(message = "请输入用户名")
    @Length(min = 1,max = 20,message = "账号必须1~20个字符之间")
    private String username;
    @NotEmpty(message = "请输入密码")
    @Length(min = 1,max = 20,message = "密码必须1~20个字符之间")
    private String userpassword;
    private String usertoken;
    private String usernick;
    private String useremail;
    private Integer userstatus;
}
