package com.baize.crm.workbench.web.controller;

import com.baize.crm.settings.domain.User;
import com.baize.crm.settings.service.UserService;
import com.baize.crm.settings.service.impl.UserServiceImpl;
import com.baize.crm.utils.MD5Util;
import com.baize.crm.utils.PrintJson;
import com.baize.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author baize
 * @Date 2021/5/15 10:54
 * @Version 1.0
 */
public class ActivityController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到市场活动控制器");
        String path = request.getServletPath();
        if ("/workbench/activity/xxx.do".equals(path)) {

        } else if ("/workbench/activity/xxx.do".equals(path)) {

        }
    }


}
