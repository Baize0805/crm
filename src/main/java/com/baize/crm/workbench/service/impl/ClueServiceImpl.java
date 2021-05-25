package com.baize.crm.workbench.service.impl;

import com.baize.crm.utils.SqlSessionUtil;
import com.baize.crm.vo.PaginationVO;
import com.baize.crm.workbench.dao.ClueDao;
import com.baize.crm.workbench.domain.Clue;
import com.baize.crm.workbench.service.ClueService;

import java.util.List;
import java.util.Map;

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

    @Override
    public PaginationVO pageList(Map<String, Object> map) {
        //取得total
        int total = clueDao.getTotalByCondition(map);
        //取得dataList
        List<Clue> dataList = clueDao.getActivityListByCondition(map);
        //将total和dataList封装到vo中
        PaginationVO<Clue> vo = new PaginationVO<Clue>();
        vo.setTotal(total);
        vo.setDataList(dataList);
        return vo;
    }
}
