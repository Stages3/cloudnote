package com.yc.cloudnoteuser.web;


import com.yc.cloudnote.bean.User;
import com.yc.cloudnote.biz.BizException;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnoteuser.biz.UserBiz;

import com.yc.cloudnoteuser.dao.UserDao;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RestController
public class UserAction {
    private static final Logger log = LoggerFactory.getLogger(UserAction.class);
    @Resource
    private UserBiz userBiz;

    @Autowired
    private UserDao userDao;

    /***
     * 注册方法
     */
    @PostMapping("adduser")
    public @ResponseBody
    Result addNewUser (
            @RequestParam String name,
            @RequestParam String nick,
            @RequestParam String password,
            User user) {

        user.setUsername(name);
        user.setUsernick(nick);
        user.setUserpassword(password);
        userDao.save(user);
        log.info(user.toString()+" saved to the repo");
        //需要改动
        return Result.success("注册成功!",user);
    }

    /***
     * 登录方法
     */

    @PostMapping("login")
    public Result Login(@Valid User user, Errors errors, HttpSession session) {//@Valid:验证注解，表示对该对象验证
        if (errors.hasFieldErrors("username") || errors.hasFieldErrors("userpassword")) {
            return Result.failure("输入错误！", errors.getFieldErrors());
        }
        try {
            User dbuser = userBiz.login(user);
            session.setAttribute("loginedAdmin", dbuser);
            return Result.success("登录成功！", errors.getFieldErrors());
        } catch (BizException e) {
            e.printStackTrace();
            //自定义的验证失败信息
            errors.reject("accountOrPwdError", e.getMessage());
            //
            return Result.failure(e.getMessage(), errors.getAllErrors());
        }
    }




}
