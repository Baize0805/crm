package com.baize.crm.workbench.service;

import com.baize.crm.vo.PaginationVO;
import com.baize.crm.workbench.domain.Clue;

import java.util.Map;

/**
 * @Author baize
 * @Date 2021/5/24 9:25
 * @Version 1.0
 */
public interface ClueService {
    boolean save(Clue c);

    PaginationVO pageList(Map<String, Object> map);

    boolean delete(String[] ids);
}
