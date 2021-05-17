package com.baize.crm.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author baize
 * @Date 2021/5/16 16:34
 * @Version 1.0
 */
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入到过滤字符编码的过滤器");
        //过滤post请求中文参数乱码
        req.setCharacterEncoding("UTF-8");
        //过滤响应流响应中文乱码
        resp.setContentType("text/html;charset=utf-8");

        //将请求放行
        filterChain.doFilter(req,resp);

    }

}
