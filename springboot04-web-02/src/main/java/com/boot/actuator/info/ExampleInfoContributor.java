package com.boot.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * 编写自定义info
 */
@Component
public class ExampleInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","你好")
                .withDetail("hello","guigu")
                .withDetails(Collections.singletonMap("world","66666"));
    }
}
