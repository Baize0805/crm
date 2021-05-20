package com.baize.crm.workbench.service;

import com.baize.crm.vo.PaginationVO;
import com.baize.crm.workbench.domain.Activity;

import java.util.Map;

/**
 * @Author baize
 * @Date 2021/5/17 14:49
 * @Version 1.0
 */
public interface ActivityService {
    boolean save(Activity a);

    PaginationVO pageList(Map<String, Object> map);

    boolean delete(String[] ids);

    Map<String, Object> getUserListAndActivity(String id);

    boolean update(Activity a);

    Activity detail(String id);
}
