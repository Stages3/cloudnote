package com.yc.cloudnoteuser.biz;

import com.yc.cloudnote.bean.User;

public interface UserBizBack {

    /**
     * 根据条件查询用户
     * @return
     */
    public User findById(Integer userid);
}
