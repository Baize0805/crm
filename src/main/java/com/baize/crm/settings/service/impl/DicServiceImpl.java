package com.baize.crm.settings.service.impl;

import com.baize.crm.settings.dao.DicTypeDao;
import com.baize.crm.settings.dao.DicValueDao;
import com.baize.crm.settings.service.DicService;
import com.baize.crm.utils.SqlSessionUtil;

/**
 * @Author baize
 * @Date 2021/5/24 9:43
 * @Version 1.0
 */
public class DicServiceImpl implements DicService {
    private DicTypeDao dicTypeDao = SqlSessionUtil.getSqlSession().getMapper(DicTypeDao.class);
    private DicValueDao dicValueDao = SqlSessionUtil.getSqlSession().getMapper(DicValueDao.class);
}
