package com.baize.crm.workbench.service.impl;

import com.baize.crm.utils.SqlSessionUtil;
import com.baize.crm.workbench.dao.ClueDao;
import com.baize.crm.workbench.domain.Clue;
import com.baize.crm.workbench.service.ClueService;

/**
 * @Author baize
 * @Date 2021/5/24 9:25
 * @Version 1.0
 */
public class ClueServiceImpl implements ClueService {
    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);

    @Override
    public boolean save(Clue c) {
        boolean flag = true;
        int count = clueDao.save(c);
        if (count != 1) {
            flag = false;
        }

        return flag;
    }
}
