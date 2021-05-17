package com.baize.crm.workbench.web.controller;

import com.baize.crm.settings.domain.User;
import com.baize.crm.settings.service.UserService;
import com.baize.crm.settings.service.impl.UserServiceImpl;
import com.baize.crm.utils.PrintJson;
import com.baize.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        if ("/workbench/activity/getUserList.do".equals(path)) {
            getUserList(request,response);
        } else if ("/workbench/activity/xxx.do".equals(path)) {

        }
    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("获取用户信息列表");

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        List<User> uList = us.getUserList();

        PrintJson.printJsonObj(response,uList);



    }


}
