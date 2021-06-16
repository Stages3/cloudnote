package com.yc.cloudnoteuser.service;

import com.yc.cloudnote.bean.User;
import com.yc.cloudnoteuser.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务逻辑类
 * @author pan_junbiao
 **/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User save(User user) {
        return null;
    }
}
