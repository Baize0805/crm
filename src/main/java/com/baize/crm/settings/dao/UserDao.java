package com.baize.crm.settings.dao;

import com.baize.crm.settings.domain.User;

import java.util.Map;

/**
 * @Author baize
 * @Date 2021/5/15 10:45
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 用户登录数据
     * @param map
     * @return
     */
    User login(Map<String, String> map);
}
