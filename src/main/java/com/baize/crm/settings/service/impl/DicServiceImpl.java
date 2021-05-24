package com.baize.crm.settings.service.impl;

import com.baize.crm.settings.dao.DicTypeDao;
import com.baize.crm.settings.dao.DicValueDao;
import com.baize.crm.settings.domain.DicType;
import com.baize.crm.settings.domain.DicValue;
import com.baize.crm.settings.service.DicService;
import com.baize.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author baize
 * @Date 2021/5/24 9:43
 * @Version 1.0
 */
public class DicServiceImpl implements DicService {
    private DicTypeDao dicTypeDao = SqlSessionUtil.getSqlSession().getMapper(DicTypeDao.class);
    private DicValueDao dicValueDao = SqlSessionUtil.getSqlSession().getMapper(DicValueDao.class);

    @Override
    public Map<String, List<DicValue>> getAll() {

        Map<String, List<DicValue>> map = new HashMap<String, List<DicValue>>();

        //将字典类型列表取出
        List<DicType> dicTypeList = dicTypeDao.getTypeList();

        //将字典类型列表遍历
        for (DicType dt : dicTypeList){
            //取得每一种类型的字典类型编码
            String code = dt.getCode();

            //根据每一个字典类型来取得字典值列表
            List<DicValue> dvList = dicValueDao.getListByCode(code);

            map.put(code+"List",dvList);

        }

        return map;
    }
}
