package com.baize.crm.vo;

import java.util.List;

/**
 * @Author baize
 * @Date 2021/5/18 10:37
 * @Version 1.0
 */
public class PaginationVO<T> {
    private int total;
    private List<T> dataList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
