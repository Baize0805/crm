package com.baize.crm.workbench.service.impl;

import com.baize.crm.utils.SqlSessionUtil;
import com.baize.crm.workbench.dao.CustomerDao;
import com.baize.crm.workbench.service.CustomerService;

import java.util.List;

/**
 * @Author baize
 * @Date 2021/5/28 15:18
 * @Version 1.0
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = SqlSessionUtil.getSqlSession().getMapper(CustomerDao.class);


    @Override
    public List<String> getCustomerName(String name) {
        List<String> sList = customerDao.getCustomerName(name);

        return sList;
    }
}
