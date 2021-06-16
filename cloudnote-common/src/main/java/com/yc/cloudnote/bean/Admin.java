package com.yc.cloudnote.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
@Table
@Entity
public class Admin implements Serializable {
    @Id
    private Integer id;
    @NotEmpty(message = "请填写账号！！！")
    @Length(min = 2,max = 20,message = "账号必须是2-20个字符")
    private String account;
    private String name;
    @NotEmpty(message = "请填写密码！！！")
    @Length(min = 6,max = 20,message = "密码必须是2-20个字符")
    private String pwd;
    private String gender;
    private Date birthday;
    private String address;
    private String phone;
    private String email;
    private String school;
    private String education;
    private String profession;
    private String job;
}
