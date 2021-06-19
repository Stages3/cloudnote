package com.yc.cloudnoteuser.biz;

//import static org.junit.Assert.*;

import com.yc.cloudnote.bean.Admin;
import com.yc.cloudnote.biz.BizException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
public class AdminBizTest {

    @Resource
    private AdminBiz adminBiz;

    @Test
    @Transactional
    public void TestAdminLogin() throws BizException {
        Admin admin = new Admin();
        admin.setAccount("admin");
        admin.setPwd("111111");
        Admin dbAdmin = adminBiz.Login(admin);
        System.out.println(dbAdmin);
    }
}