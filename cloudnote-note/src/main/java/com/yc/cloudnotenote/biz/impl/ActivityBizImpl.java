package com.yc.cloudnotenote.biz.impl;

import com.yc.cloudnote.bean.Activity;
import com.yc.cloudnotenote.biz.ActivityBiz;
import com.yc.cloudnotenote.dao.ActivityDao;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @description:
 * @author:
 * @create: 2021-06-22 01:48
 */
@Service
public class ActivityBizImpl implements ActivityBiz {
    @Resource
    private ActivityDao activityDao;

    @Override
    public Activity addActive(Activity activity) {
        return activityDao.save(activity);
    }

    @Override
    public Activity findByTitle(String activitytitle) {
        Activity activity = new Activity();
        activity.setActivitytitle(activitytitle);
        Example<Activity> example =Example.of(activity);
        Optional<Activity> optional = activityDao.findOne(example);
        return optional.get();
    }
}
