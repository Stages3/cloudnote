package com.yc.cloudnoteuser.web;

import com.yc.cloudnote.bean.Admin;
import com.yc.cloudnote.biz.BizException;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnoteuser.biz.AdminBiz;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @description:
 * @author: 赵俊华
 * @create: 2021-06-07 18:53
 */
@RestController
public class AdminAction {
    @Resource
    private AdminBiz adminBiz;

    @PostMapping("loginback")
    public Result Login(@Valid Admin admin, Errors errors, HttpSession session){//@Valid:验证注解，表示对该对象验证
        if(errors.hasFieldErrors("account") || errors.hasFieldErrors("pwd")){
            return Result.failure("输入错误！",errors.getFieldErrors());
        }
        try {
            Admin dbAdmin = adminBiz.Login(admin);
            session.setAttribute("loginedAdmin",dbAdmin);
            return Result.success("登录成功！",errors.getFieldErrors());
        } catch (BizException e) {
            e.printStackTrace();
            //自定义的验证失败信息
            errors.reject("accountOrPwdError",e.getMessage());
            //
            return Result.failure(e.getMessage(),errors.getAllErrors());
        }
    }

    /**
     *  获取登陆对象
     * @param loginedAdmin 加@SessionAttribute：从session会话取出对象，名字必须与存入的时候一致
     *                     required = false : 表示这个属性“非必需”,若是不加，则未登录时loginUser为空，后台会报错
     * @return
     */
    @GetMapping("getLoginedAdmin")
    public Result getLoginedAdmin(@SessionAttribute(required = false) Admin loginedAdmin){
        return Result.success("登录对象获取成功",loginedAdmin);
    }

    /**
     *退出
     * @param mav   模型视图对象，可以实现跳转
     * @param session
     * @return
     */
    @GetMapping("logoutback")
    public ModelAndView logout(ModelAndView mav, HttpSession session){
        session.invalidate();
        mav.setViewName("redirect:http://127.0.0.1/back_login.html");
        return mav;
    }
}
