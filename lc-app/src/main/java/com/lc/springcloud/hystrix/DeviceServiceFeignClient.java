package com.lc.springcloud.hystrix;

import com.lc.springcloud.hystrix.fallback.DeviceServiceFeignClientHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "lc-device",fallback = DeviceServiceFeignClientHystric.class)
public interface DeviceServiceFeignClient {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String testDevice(@RequestParam(value = "name") String name);
}