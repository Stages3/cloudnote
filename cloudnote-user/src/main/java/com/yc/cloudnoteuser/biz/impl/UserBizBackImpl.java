package com.yc.cloudnoteuser.biz.impl;

import com.yc.cloudnote.bean.User;
import com.yc.cloudnoteuser.biz.UserBizBack;
import com.yc.cloudnoteuser.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author:
 * @create: 2021-06-23 19:06
 */
@Service
public class UserBizBackImpl implements UserBizBack {
    @Autowired
    private UserDao dao;

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findById(Integer userid) {
        User user = new User();
        user.setUserid(userid);
        Example<User> example = Example.of(user);
        Optional<User> optional = dao.findOne(example);
        return optional.get();
    }
}
