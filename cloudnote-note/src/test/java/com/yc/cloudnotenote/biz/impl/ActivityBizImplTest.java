package com.yc.cloudnotenote.biz.impl;

import com.yc.cloudnote.bean.Activity;
import com.yc.cloudnotenote.biz.ActivityBiz;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;

@SpringBootTest
public class ActivityBizImplTest {

    @Resource
    private ActivityBiz activityBiz;

    @Test
    public void TestAddAc(){
        Activity activity = new Activity();
        activity.setActivitytitle("javaee测试第三次");
        activity.setActivitybody("Java EE 是 J2EE的一个新的名称，之所以改名，目的还是让大家清楚J2EE只是Java企业应用。");

        Timestamp timestamp0  = new Timestamp(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        c.setTime(timestamp0);
        c.add(Calendar.DATE, 1);  //  加一  天
        //c.add(Calendar.MONTH, 1); //  加一个月
        //c.add(Calendar.YEAR,1);   //  加一  年
        Timestamp time1 = new Timestamp(c.getTimeInMillis()+86400000);
        activity.setActivityendtime(time1);
        //activity.setActivityendtime(new Timestamp( new Date().getTime()+86400000));
        activity.setActivitybegtime(activity.getDeliveryTime());

        activityBiz.addActive(activity);
    }

    @Test
    public void TestFindByTitle(){
        Activity activity = activityBiz.findByTitle("javaee测试第三次");
        System.out.println("查询："+activity);
    }

}