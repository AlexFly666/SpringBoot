package com.newcapec.web.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Title:普通类调用Spring bean对象
 * @ClassName: com.newcapec.web.utils.SpringBeanUtils.java
 * @Description: 此类需要放到App.java同包或者子包下才能被扫描，否则失效。
 * @Copyright 2016-2017 新开普 - Powered By 研发中心
 * @author: 王延飞
 * @date:2017-03-19 21:03
 */
@Component
public class SpringBeanUtils implements ApplicationContextAware {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringBeanUtils.applicationContext == null) {
            SpringBeanUtils.applicationContext = applicationContext;

        }

        logger.info("========ApplicationContext配置成功,SpringBeanUtils.getAppContext()获取applicationContext对象,applicationContext=" + SpringBeanUtils.applicationContext + "========");
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}