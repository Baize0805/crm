package com.baize.crm.workbench.dao;

import com.baize.crm.workbench.domain.ClueRemark;

import java.util.List;

public interface ClueRemarkDao {

    int getCountByAids(String[] ids);

    int deleteByAids(String[] ids);

    List<ClueRemark> getListByClueId(String clueId);

    int delete(ClueRemark clueRemark);
}
