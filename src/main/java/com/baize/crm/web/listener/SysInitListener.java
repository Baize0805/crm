package com.baize.crm.web.listener;

import com.baize.crm.settings.domain.DicValue;
import com.baize.crm.settings.service.DicService;
import com.baize.crm.settings.service.impl.DicServiceImpl;
import com.baize.crm.utils.ServiceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author baize
 * @Date 2021/5/24 14:59
 * @Version 1.0
 */
public class SysInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        System.out.println("上下文域对象创建了！");
        System.out.println("服务器处理缓存处理数据字典开始");
        ServletContext application = sce.getServletContext();

        DicService ds = (DicService) ServiceFactory.getService(new DicServiceImpl());

        Map<String, List<DicValue>> map = ds.getAll();
        //将map解析为上下文域对象中保存的键值对
        Set<String> set = map.keySet();
        for (String key : set){
            application.setAttribute(key,map.get(key));
        }
        System.out.println("服务器缓存处理数据字典结束");

    }

}
