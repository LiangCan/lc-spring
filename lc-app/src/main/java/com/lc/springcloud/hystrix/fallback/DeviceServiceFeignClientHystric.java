package com.lc.springcloud.hystrix.fallback;

import com.lc.springcloud.hystrix.DeviceServiceFeignClient;
import org.springframework.stereotype.Component;

@Component
public class DeviceServiceFeignClientHystric implements DeviceServiceFeignClient {
    @Override
    public String testDevice(String name) {
        return "sorry ！！！" + name;
    }
}