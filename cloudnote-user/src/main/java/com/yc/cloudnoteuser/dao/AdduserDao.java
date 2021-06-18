package com.yc.cloudnoteuser.dao;

import com.yc.cloudnote.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdduserDao extends JpaRepository<User,Integer> {

}
