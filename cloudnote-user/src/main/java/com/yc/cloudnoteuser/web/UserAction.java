package com.yc.cloudnoteuser.web;


import com.yc.cloudnote.bean.User;
import com.yc.cloudnote.biz.BizException;
import com.yc.cloudnote.vo.Result;
import com.yc.cloudnoteuser.biz.UserBiz;

import com.yc.cloudnoteuser.dao.UserDao;
import com.yc.cloudnoteuser.util.NoteResult;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
     * 修改密码的方法
     */
    @PostMapping("/change.do")
    public @ResponseBody
    NoteResult<Object> updata (
            @RequestParam String userName,
            @RequestParam String last_password,
            @RequestParam String final_password,
            User user){
        //返回结果
        NoteResult<Object> result=new NoteResult<Object>();
        user.setUsername(userName);
        User user1=userDao.findByUsername(userName);
        //获得原密码
        String user_password = user1.getUserpassword();
        //对传入的密码需加密才能比较

        System.out.println(user_password);
        System.out.println(last_password);
        System.out.println(final_password);
        //进行比较 密码不相等的话
        if(!user_password.equals(last_password)) {
            result.setStatus(1);
            result.setMsg("原密码不正确");
            return result;
        }else if(user_password.equals(final_password)) {
            result.setStatus(2);
            result.setMsg("要修改的密码与原密码一致");
            return result;
        }else{
            //密码正确，执行修改密码操作
            user1.setUserpassword(final_password);
            userDao.save(user1);
            result.setStatus(0);
            result.setMsg("修改密码成功");
            return result;
        }
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
            session.setAttribute("loginedUser", dbuser);
            return Result.success("登录成功！",dbuser);
        } catch (BizException e) {
            e.printStackTrace();
            //自定义的验证失败信息
            errors.reject("accountOrPwdError", e.getMessage());
            //
            return Result.failure(e.getMessage(), errors.getAllErrors());
        }
    }

    /***
     * 退出登录方法
     */
//    @GetMapping("logoutback")
//    public ModelAndView logout(ModelAndView mav, HttpSession session){
//        session.invalidate();
//        mav.setViewName("redirect:http://127.0.0.1/back_login.html");
//        return mav;
//    }





}
