package com.baize.crm.workbench.service.impl;

import com.baize.crm.utils.SqlSessionUtil;
import com.baize.crm.workbench.dao.ActivityDao;
import com.baize.crm.workbench.service.ActivityService;

/**
 * @Author baize
 * @Date 2021/5/17 14:50
 * @Version 1.0
 */
public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
}
