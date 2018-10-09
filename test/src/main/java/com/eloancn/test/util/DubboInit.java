package com.eloancn.test.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by eloancn on 2018/4/2.
 */
public class DubboInit {
    private static DubboInit init = null;
    private DubboInit(){}
    private  static ApplicationContext context;
    public synchronized static DubboInit getInstance(){
        if(init == null){
            init = new DubboInit();
        }
        return init;
    }

    public  static void  initApplicationContext(){
        context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dubbo.xml");
        if(context==null)
        {
            throw new IllegalArgumentException("Load applicationContext-dubbo.xml fail");
        }
    }

    public  Object getBean(String beanName) {
        return context.getBean(beanName);
    }
}
