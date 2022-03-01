package com.boot.servlet;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Web原生组件注入（Servlet、Filter、Listener）方法二
 *使用RegistrationBean
 * ServletRegistrationBean, FilterRegistrationBean, and ServletListenerRegistrationBean
 */
//(proxyBeanMethods = true);保证依赖的组件是单实例的，如果是false就每次调用都会新建
@Configuration  //表示配置类
public class MyRegistConfig {

    @Bean   //注册组件
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet,"/my");
    }


    @Bean
    public FilterRegistrationBean myFilter(){

        MyFilter myFilter = new MyFilter();

        //把myServlet传进来，就只拦截myServlet的路径
        //return new FilterRegistrationBean(myFilter,myServlet());

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return filterRegistrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean myListener(){
        MySwervletContextListener mySwervletContextListener = new MySwervletContextListener();

        return new ServletListenerRegistrationBean(mySwervletContextListener);
    }


}
