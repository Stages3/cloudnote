package com.yc.cloudnotenote.dao;

import com.yc.cloudnote.bean.Activitydetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityDetailDao extends JpaRepository<Activitydetail,Integer> {
}
