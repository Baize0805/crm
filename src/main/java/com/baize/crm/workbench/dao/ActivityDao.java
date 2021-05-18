package com.baize.crm.workbench.dao;

import com.baize.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

/**
 * @Author baize
 * @Date 2021/5/17 14:46
 * @Version 1.0
 */
public interface ActivityDao {
    int save(Activity a);

    List<Activity> getActivityListByCondition(Map<String, Object> map);

    int getTotalByCondition(Map<String, Object> map);
}
