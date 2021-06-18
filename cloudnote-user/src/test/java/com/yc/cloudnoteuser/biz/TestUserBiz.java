package com.yc.cloudnoteuser.biz;

import com.yc.cloudnote.bean.User;
import com.yc.cloudnote.biz.BizException;
import com.yc.cloudnoteuser.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@SpringBootTest
public class TestUserBiz {
    @Resource
    private UserBiz userBiz;
    @Test
    @Transactional
    public void findUserBiz() throws BizException {
        User user=new User();
        user.setUsername("aaaaaa");
        user.setUserpassword("aaaaaa");
       System.out.println(userBiz.login(user));
    }
}
