package com.yc.cloudnoteuser.web;


import com.yc.cloudnote.bean.User;
import com.yc.cloudnote.biz.BizException;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnoteuser.biz.UserBiz;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RestController
public class UserAction {
    @Resource
    private UserBiz userBiz;

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
    }}
