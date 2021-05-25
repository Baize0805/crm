package com.baize.crm.workbench.dao;

import com.baize.crm.workbench.domain.Clue;

import java.util.List;
import java.util.Map;

public interface ClueDao {


    int save(Clue c);

    int getTotalByCondition(Map<String, Object> map);

    List<Clue> getActivityListByCondition(Map<String, Object> map);

    int delete(String[] ids);

    Clue getById(String id);

    int update(Clue c);
}
