package com.baize.crm.settings.service;

import com.baize.crm.exception.LoginException;
import com.baize.crm.settings.domain.User;

import java.util.List;

/**
 * @Author baize
 * @Date 2021/5/15 10:49
 * @Version 1.0
 */
public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
