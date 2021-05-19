package com.baize.crm.workbench.dao;

/**
 * @Author baize
 * @Date 2021/5/17 23:45
 * @Version 1.0
 */
public interface ActivityRemarkDao {
    int getCountByAids(String[] ids);

    int deleteByAids(String[] ids);
}
