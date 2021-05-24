package com.baize.crm.settings.dao;

import com.baize.crm.settings.domain.DicValue;

import java.util.List;

/**
 * @Author baize
 * @Date 2021/5/24 9:38
 * @Version 1.0
 */
public interface DicValueDao {
    List<DicValue> getListByCode(String code);
}
