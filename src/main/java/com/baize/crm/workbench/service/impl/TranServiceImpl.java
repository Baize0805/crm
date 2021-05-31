package com.baize.crm.workbench.service.impl;

import com.baize.crm.utils.SqlSessionUtil;
import com.baize.crm.workbench.dao.TranDao;
import com.baize.crm.workbench.dao.TranHistoryDao;
import com.baize.crm.workbench.service.TranService;

/**
 * @Author baize
 * @Date 2021/5/28 14:20
 * @Version 1.0
 */
public class TranServiceImpl implements TranService {
    private TranDao tranDao = SqlSessionUtil.getSqlSession().getMapper(TranDao.class);
    private TranHistoryDao tranHistoryDao = SqlSessionUtil.getSqlSession().getMapper(TranHistoryDao.class);



}
