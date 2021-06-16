package com.yc.cloudnote.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Activitydetail {
    @Id
    private Integer noteactivityid;
    private Integer activityid;
    private Integer userid;
    private String username;
    private Integer noteid;
    private Integer noteactivityup;
    private Integer noteactivitydown;
    private String noteactivitytitle;
    private String noteactivitybody;
    private Integer noteactivitystatus;

}
