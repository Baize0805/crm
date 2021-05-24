package com.baize.crm.workbench.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author baize
 * @Date 2021/5/15 10:54
 * @Version 1.0
 */
public class ClueController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到“线索”控制器");
        String path = request.getServletPath();
        if ("/workbench/clue/getUserList.do".equals(path)) {

        }else if ("/workbench/clue/getUserList.do".equals(path)){

        }
    }




}
