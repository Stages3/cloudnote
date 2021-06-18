package com.yc.cloudnoteuser.dao;

import com.yc.cloudnote.bean.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class AdminDaoTest {

    @Resource
    private AdminDao adminDao;

    @Test
    public void TestAdminLogin(){
        Admin admin = new Admin();
        admin.setAccount("admin");
        admin.setPwd("111111");
        Admin dbAdmin = adminDao.findByAccountAndPwd(admin.getAccount(),admin.getPwd());
        System.out.println(dbAdmin);
    }
}