package com.yc.cloudnoteuser.biz;

import com.yc.cloudnote.bean.User;
import com.yc.cloudnote.biz.BizException;
import com.yc.cloudnoteuser.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * 业务层--->作用是：
 */
@Service
public class UserBiz {
    @Resource
    private UserDao userDao;
    public User login(User user) throws BizException {
        User dbUser =userDao.findByUsernameAndUserpassword(user.getUsername(),user.getUserpassword());
        if (dbUser==null){
            throw new BizException("用户或者密码错误");
        }
        return dbUser;
    }

}
