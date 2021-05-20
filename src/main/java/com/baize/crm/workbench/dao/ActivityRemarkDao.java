package com.baize.crm.workbench.dao;

import com.baize.crm.workbench.domain.ActivityRemark;

import java.util.List;

/**
 * @Author baize
 * @Date 2021/5/17 23:45
 * @Version 1.0
 */
public interface ActivityRemarkDao {
    int getCountByAids(String[] ids);

    int deleteByAids(String[] ids);

    List<ActivityRemark> getRemarkListByAid(String activityId);

    int deleteById(String id);

    int saveRemark(ActivityRemark ar);
}
