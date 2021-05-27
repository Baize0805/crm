package com.baize.crm.workbench.service.impl;

import com.baize.crm.settings.dao.UserDao;
import com.baize.crm.settings.domain.User;
import com.baize.crm.utils.SqlSessionUtil;
import com.baize.crm.utils.UUIDUtil;
import com.baize.crm.vo.PaginationVO;
import com.baize.crm.workbench.dao.ClueActivityRelationDao;
import com.baize.crm.workbench.dao.ClueDao;
import com.baize.crm.workbench.dao.ClueRemarkDao;
import com.baize.crm.workbench.domain.Clue;
import com.baize.crm.workbench.domain.ClueActivityRelation;
import com.baize.crm.workbench.service.ClueService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author baize
 * @Date 2021/5/24 9:25
 * @Version 1.0
 */
public class ClueServiceImpl implements ClueService {
    private ClueDao clueDao = SqlSessionUtil.getSqlSession().getMapper(ClueDao.class);
    private ClueRemarkDao clueRemarkDao = SqlSessionUtil.getSqlSession().getMapper(ClueRemarkDao.class);
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
    private ClueActivityRelationDao clueActivityRelationDao = SqlSessionUtil.getSqlSession().getMapper(ClueActivityRelationDao.class);

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

    @Override
    public boolean delete(String[] ids) {
        boolean flag = true;
        int count1 =  clueRemarkDao.getCountByAids(ids);
        int count2 =  clueRemarkDao.deleteByAids(ids);
        if (count1 != count2) {
            flag = false;
        }
        //删除市场活动
        int count3 = clueDao.delete(ids);
        if (count3 != ids.length) {
            flag = false;
        }


        return flag;
    }

    @Override
    public Map<String, Object> getUserListAndClue(String id) {
        //取uList
        List<User> uList = userDao.getUserList();

        //取c
        Clue c = clueDao.getById(id);

        //将uList和a打包到map中
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uList", uList);
        map.put("c", c);

        return map;
    }

    @Override
    public boolean update(Clue c) {
        boolean flag = true;

        int count = clueDao.update(c);
        if (count != 1) {
            flag = false;
        }

        return flag;
    }

    @Override
    public Clue detail(String id) {

        Clue c = clueDao.detail(id);
        return c;
    }

    @Override
    public boolean unbund(String id) {
        boolean flag = true;
        int count = clueActivityRelationDao.unbund(id);
        if (count!=1){
            flag = false;
        }

        return flag;
    }

    @Override
    public boolean bund(String cid, String[] aids) {
        boolean flag = true;

        for (String aid:aids){
            ClueActivityRelation car = new ClueActivityRelation();
            car.setId(UUIDUtil.getUUID());
            car.setClueId(cid);
            car.setActivityId(aid);

            int count = clueActivityRelationDao.bund(car);
            if (count != 1){
                flag = false;
            }

        }


        return flag;
    }
}
