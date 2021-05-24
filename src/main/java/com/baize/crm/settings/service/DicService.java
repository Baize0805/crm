package com.baize.crm.settings.service;

import com.baize.crm.settings.domain.DicValue;

import java.util.List;
import java.util.Map;

/**
 * @Author baize
 * @Date 2021/5/24 9:42
 * @Version 1.0
 */
public interface DicService {
    Map<String, List<DicValue>> getAll();
}
