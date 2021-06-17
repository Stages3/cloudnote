package com.yc.cloudnoteuser.dao;

import com.yc.cloudnote.bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Integer> {

    Admin findByAccountAndPwd(String account, String pwd);
}
