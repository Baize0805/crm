package com.baize.crm.settings.dao;

import com.baize.crm.settings.domain.DicType;

import java.util.List;

/**
 * @Author baize
 * @Date 2021/5/24 9:37
 * @Version 1.0
 */
public interface DicTypeDao {
    List<DicType> getTypeList();
}
