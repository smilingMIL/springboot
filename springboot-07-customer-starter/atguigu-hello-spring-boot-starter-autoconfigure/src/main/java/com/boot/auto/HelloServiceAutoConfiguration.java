package com.boot.auto;

import com.boot.bean.HelloProperties;
import com.boot.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)   //默认HelloProperties放在容器中。开启属性绑定功能
public class HelloServiceAutoConfiguration {

    @ConditionalOnMissingBean(HelloService.class)   //当你容器中没有配置这个配置类的时候才执行下面
    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        return helloService;
    }
}
