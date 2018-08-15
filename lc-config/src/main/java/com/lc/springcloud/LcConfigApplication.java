package com.lc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LcConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run( LcConfigApplication.class, args );
    }

}



