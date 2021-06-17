package com.yc.cloudnoteuser.biz;

import com.yc.cloudnote.bean.Admin;
import com.yc.cloudnote.biz.BizException;
import com.yc.cloudnoteuser.dao.AdminDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 管理员登录
 * @author: 赵俊华
 * @create: 2021-06-07 18:45
 */
@Service
public class AdminBiz {

    @Resource
    private AdminDao adminDao;

    public Admin Login(Admin admin) throws BizException {
        Admin dbAdmin = adminDao.findByAccountAndPwd(admin.getAccount(),admin.getPwd());
        if(dbAdmin==null){
            throw new BizException("用户名或密码错误!"); //抛出异常
        }
        return dbAdmin;
    }

}
