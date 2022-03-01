package com.boot.config;


import com.boot.interceptor.LoginInterceptor;
import com.boot.interceptor.RedisUrlCountInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 定制springMVC的功能
 *
 * 一拦截器的步骤：
 * 1.编写一个拦截器实现HandlerInterceptor接口
 * 2.拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors的方法）
 * 3.指定拦截规则【如果拦截所有，静态资源也会被拦截】
 *
 * @EnableWebMvc：全面接管
 *              1.静态资源？全部失效
 *              2.
 */

//@EnableWebMvc
@Configuration //标识为 配置类
public class AdminWebConfig implements WebMvcConfigurer {

    /**
     * Filter.Interceptor 几乎拥有相同的功能？
     * Filter：是Servlet定义的原生组件，好处，脱离Spring应用也能使用
     * Interceptor：是spring定义的接口，可以使用spring的自动装配等功能
     */
    //@Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

/*    *//**
     * 定义静态资源行为
     * @param registry
     *//*
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //访问
        registry.addResourceHandler("/static/**")
                .addResourceLocations("class:/static/");
    }*/



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加登录拦截器
        registry.addInterceptor(new LoginInterceptor())
                //添加拦截路径
                .addPathPatterns("/**") //所有请求都会被拦截，包括静态资源
                //添加不拦截路径
                .excludePathPatterns("/","/login","/css/**","/fonts/**",
                        "/images/**","/js/**","/news"); //放行静态资源


        //redis的拦截器
/*        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**",
                        "/images/**","/js/**");*/
    }


}
