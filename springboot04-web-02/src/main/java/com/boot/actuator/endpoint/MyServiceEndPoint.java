package com.boot.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myservice")//定义自己的端点名字
public class MyServiceEndPoint {

    @ReadOperation//标识为读方法
    public Map getDockerInfo(){
        //端点的读操作
        return Collections.singletonMap("dockerInfo","docker started....");
    }

    @WriteOperation//标识为写方法
    public void stopDocker(){
        System.out.println("docker stopped....");
    }
}
