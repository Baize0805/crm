package com.baize.crm.workbench.service.impl;

import com.baize.crm.utils.SqlSessionUtil;
import com.baize.crm.vo.PaginationVO;
import com.baize.crm.workbench.dao.ActivityDao;
import com.baize.crm.workbench.domain.Activity;
import com.baize.crm.workbench.service.ActivityService;

import java.util.List;
import java.util.Map;

/**
 * @Author baize
 * @Date 2021/5/17 14:50
 * @Version 1.0
 */
public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

    @Override
    public boolean save(Activity a) {
        boolean flag = true;

        int count = activityDao.save(a);
        if (count != 1){
            flag = false;
        }

        return flag;
    }

    @Override
    public PaginationVO pageList(Map<String, Object> map) {
        //取得total
        int total = activityDao.getTotalByCondition(map);
        //取得dataList
        List<Activity> dataList = activityDao.getActivityListByCondition(map);
        //将total和dataList封装到vo中
        PaginationVO<Activity> vo = new PaginationVO<Activity>();
        vo.setTotal(total);
        vo.setDataList(dataList);
        return vo;
    }
}
