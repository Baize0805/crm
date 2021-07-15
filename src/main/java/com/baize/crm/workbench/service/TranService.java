package com.baize.crm.workbench.service;

import com.baize.crm.workbench.domain.Tran;
import com.baize.crm.workbench.domain.TranHistory;

import java.util.List;
import java.util.Map;

/**
 * @Author baize
 * @Date 2021/5/28 14:20
 * @Version 1.0
 */
public interface TranService {
    boolean save(Tran t, String customerName);

    Tran detail(String id);

    List<TranHistory> getHistoryListByTranId(String tranId);

    boolean changeStage(Tran t);

    Map<String, Object> getCharts();
}
