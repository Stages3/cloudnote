package com.yc.cloudnoteuser.dao;

import com.yc.cloudnote.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * 用户信息数据库访问接口
 */
public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsernameAndUserpassword(String username,String userpassword);

}
