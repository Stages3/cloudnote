package com.yc.cloudnote.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table
public class Note {
    @Id
    private Integer noteid;
    private Integer notebookid;
    private Integer userid;
    private String username;
    private Integer notestatus;
    private Integer notetype;
    private String notetitle;
    private String notebody;
    private Timestamp notecreatetime;
    private Timestamp notelastmodifytime;

    @Transient
    private String deliverytimeString;  //vo中界面的参数类型

    public Timestamp getDeliverytime() {
        Date d=null;
        if(deliverytimeString!=null){
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                d=df.parse(deliverytimeString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            notelastmodifytime=new Timestamp(d.getTime());
        }else{
            d=new Date();

        }
        notelastmodifytime=new Timestamp(d.getTime());
        return this.notelastmodifytime;
    }


}
