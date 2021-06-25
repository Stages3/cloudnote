package com.yc.cloudnote.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table

public class Notebook implements Serializable {
    private static final long serialVersionUID = 1581523235029787459L;
    @Id
    private Integer notebookid;
    private Integer userid;
    private String notebookname;
    private String notebookdesc;
    private Timestamp notebookcreatetime;
    private Integer notebookstatus;

//    @OneToOne
//    @JoinColumn(name="userid")
//    private User user;

}
