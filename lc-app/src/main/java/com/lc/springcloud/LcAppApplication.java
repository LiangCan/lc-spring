package com.lc.springcloud;

import com.lc.springcloud.hystrix.DeviceServiceFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.tags.Param;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@RefreshScope
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
@EnableCircuitBreaker
public class LcAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LcAppApplication.class, args);
	}

	@Value("${lc}")
	String foo;

	@RequestMapping(value = "/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public String hi(@RequestParam("name")String name){
		return "嘿嘿嘿 这里是 LC - APP " + foo;
	}

	@Autowired
	DeviceServiceFeignClient deviceServiceFeignClient;

	@RequestMapping(value = "/test/device")
	public String testDevice(@RequestParam("name")String name){
		return deviceServiceFeignClient.testDevice(name);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public String hiError(String name) {
		return "hi,"+name+",sorry,error!";
	}
}