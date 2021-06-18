package com.yc.cloudnoteuser;

import com.yc.cloudnote.bean.Admin;

import com.yc.cloudnote.biz.BizException;
import com.yc.cloudnoteuser.biz.AdminBiz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest

class CloudnoteUserApplicationTests {

	@Resource
	private AdminBiz adminBiz;
	@Test
	@Transactional
	public void findUserBiz() throws BizException {
		Admin admin=new Admin();
		admin.setAccount("admin");
		admin.setPwd("111111");
		System.out.println(adminBiz.Login(admin));
	}

}
