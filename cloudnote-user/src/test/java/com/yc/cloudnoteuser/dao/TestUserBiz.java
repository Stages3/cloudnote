package com.yc.cloudnoteuser.dao;

import com.yc.cloudnote.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@SpringBootTest
public class TestUserBiz {
    @Resource
    private UserDao userDao;
    @Test
    @Transactional
    public void findUser(){
        User user=new User();
        User user1=userDao.findByUsernameAndUserpassword(user.getUsername(),user.getUserpassword());
        System.out.println(user1);
    }

}
