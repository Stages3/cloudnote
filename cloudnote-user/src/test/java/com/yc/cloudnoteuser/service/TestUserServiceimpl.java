package com.yc.cloudnoteuser.service;

import com.yc.cloudnote.bean.User;
import org.junit.jupiter.api.Test;

public class TestUserServiceimpl {

    @Test
    public void save() {
        //创建新用户
        User user = new User();
        user.setUsername("p");
        user.setUserpassword("2");


        //执行新增操作


        //如果新增成功，则可以获取自增主键
        //否则新增失败，则抛出异常
        if (user.getUserid() > 0) {
            System.out.println("新增用户成功，新增的用户信息：");
            System.out.println("用户编号：" + user.getUserid());
            System.out.println("用户姓名：" + user.getUsername());

        }


    }
}
