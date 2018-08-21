package com.lc.springcloud.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/5/17 0017.
 */
@RefreshScope
@Configuration
public class ServiceConfig {

    //传输日志key
    private final String SERVICE_LOG = "serviceLog";
    public String getSERVICE_LOG() {
        return SERVICE_LOG;
    }
}
