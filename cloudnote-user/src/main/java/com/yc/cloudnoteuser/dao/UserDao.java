package com.yc.cloudnoteuser.dao;

import com.yc.cloudnote.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByUsernameAndUserpassword(String username,String userpassword);

}
