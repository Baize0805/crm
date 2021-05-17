package com.baize.settings;

import com.baize.crm.utils.MD5Util;

/**
 * @Author baize
 * @Date 2021/5/15 11:33
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) {
        String pwd = "2134532";
        String m = MD5Util.getMD5(pwd);
        System.out.println(m);

    }
}
