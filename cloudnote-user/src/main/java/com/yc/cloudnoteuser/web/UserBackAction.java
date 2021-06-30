package com.yc.cloudnoteuser.web;

import com.yc.cloudnote.bean.User;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnoteuser.biz.UserBizBack;
import com.yc.cloudnoteuser.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2021-06-23 19:22
 */
@RestController
public class UserBackAction {
    @Autowired
    private UserBizBack userBizBack;
    @Resource
    private UserDao dao;

    @RequestMapping(value = "findAllUser",method = {RequestMethod.GET,RequestMethod.POST})
    public Result findAllUser(HttpSession session, User user){
        List<User> list = dao.findAll(Example.of(user));
        //session.setAttribute("UserLIST",list);
        return Result.success("success",list);
    }

}
