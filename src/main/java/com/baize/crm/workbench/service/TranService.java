package com.baize.crm.workbench.service;

import com.baize.crm.workbench.domain.Tran;

/**
 * @Author baize
 * @Date 2021/5/28 14:20
 * @Version 1.0
 */
public interface TranService {
    boolean save(Tran t, String customerName);

    Tran detail(String id);
}
