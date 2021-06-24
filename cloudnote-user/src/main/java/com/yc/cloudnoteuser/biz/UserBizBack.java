package com.yc.cloudnoteuser.biz;

import com.yc.cloudnote.bean.User;

import java.util.List;

public interface UserBizBack {
    /**
     * 查找所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 根据条件查询用户
     * @return
     */
    public User findById(Integer userid);
}
