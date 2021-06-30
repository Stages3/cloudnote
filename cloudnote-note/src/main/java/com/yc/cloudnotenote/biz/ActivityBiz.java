package com.yc.cloudnotenote.biz;

import com.yc.cloudnote.bean.Activity;

import java.util.List;

public interface ActivityBiz {

    /**
     * 添加活动
     * @param activity
     * @return
     */
    public Activity addActive(Activity activity);

    public Activity findByTitle(String activitytitle);

    public List<Activity> findAll();

    public Activity findActivityId(Integer activityid);
}
