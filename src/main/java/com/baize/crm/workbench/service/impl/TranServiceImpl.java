package com.baize.crm.workbench.service.impl;

import com.baize.crm.utils.DateTimeUtil;
import com.baize.crm.utils.SqlSessionUtil;
import com.baize.crm.utils.UUIDUtil;
import com.baize.crm.workbench.dao.CustomerDao;
import com.baize.crm.workbench.dao.TranDao;
import com.baize.crm.workbench.dao.TranHistoryDao;
import com.baize.crm.workbench.domain.Customer;
import com.baize.crm.workbench.domain.Tran;
import com.baize.crm.workbench.domain.TranHistory;
import com.baize.crm.workbench.service.TranService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author baize
 * @Date 2021/5/28 14:20
 * @Version 1.0
 */
public class TranServiceImpl implements TranService {
    private TranDao tranDao = SqlSessionUtil.getSqlSession().getMapper(TranDao.class);
    private TranHistoryDao tranHistoryDao = SqlSessionUtil.getSqlSession().getMapper(TranHistoryDao.class);
    private CustomerDao customerDao = SqlSessionUtil.getSqlSession().getMapper(CustomerDao.class);


    @Override
    public boolean save(Tran t, String customerName) {
        boolean flag = true;

        Customer cus = customerDao.getCustomerByName(customerName);

        //如果cus等于空，需要创建一个cus
        if (cus == null) {
            cus = new Customer();
            cus.setId(UUIDUtil.getUUID());
            cus.setName(customerName);
            cus.setCreateBy(t.getCreateBy());
            cus.setCreateTime(DateTimeUtil.getSysTime());
            cus.setContactSummary(t.getContactSummary());
            cus.setNextContactTime(t.getNextContactTime());
            cus.setOwner(t.getOwner());

            //添加客户
            int count1 = customerDao.save(cus);
            if (count1 != 1) {
                flag = false;
            }
        }
        //将客户的id封装到对象中
        t.setCustomerId(cus.getId());

        //添加交易
        int count2 = tranDao.save(t);
        if (count2 != 1) {
            flag = false;
        }

        //添加交易历史
        TranHistory th = new TranHistory();
        th.setId(UUIDUtil.getUUID());
        th.setTranId(t.getId());
        th.setStage(t.getStage());
        th.setMoney(t.getMoney());
        th.setExpectedDate(t.getExpectedDate());
        th.setCreateTime(DateTimeUtil.getSysTime());
        th.setCreateBy(t.getCreateBy());
        //添加交易历史
        int count3 = tranHistoryDao.save(th);
        if (count3 != 1) {
            flag = false;
        }
        return flag;
    }

    @Override
    public Tran detail(String id) {
        Tran t = tranDao.detail(id);

        return t;
    }

    @Override
    public List<TranHistory> getHistoryListByTranId(String tranId) {

        List<TranHistory> thList = tranHistoryDao.getHistoryListByTranId(tranId);

        return thList;
    }

    @Override
    public boolean changeStage(Tran t) {
        boolean flag = true;
        //改变交易阶段
        int count1 = tranDao.changeStage(t);
        if (count1 != 1) {
            flag = false;
        }

        //生成一条交易历史
        TranHistory th = new TranHistory();
        th.setId(UUIDUtil.getUUID());
        th.setCreateBy(t.getEditBy());
        th.setCreateTime(DateTimeUtil.getSysTime());
        th.setExpectedDate(t.getExpectedDate());
        th.setMoney(t.getMoney());
        th.setTranId(t.getId());
        th.setStage(t.getStage());

        //添加交易历史的操作
        int count2 = tranHistoryDao.save(th);
        if (count2 != 1) {
            flag = false;
        }

        return flag;
    }

    @Override
    public Map<String, Object> getCharts() {

        int total = tranDao.getTotal();

        List<Map<String,Object>> dataList = tranDao.getCharts();

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",total);
        map.put("dataList",dataList);

        return map;
    }
}
