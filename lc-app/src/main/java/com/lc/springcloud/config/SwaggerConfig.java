package com.lc.springcloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Value("${spring.cloud.client.ip-address}")
    private String locIp;

    @Value("${server.port}")
    private String locPort;

    @Bean
    public Docket ProductApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .host(locIp + ":"+ locPort)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lc.springcloud"))
                .build()
                .apiInfo(productApiInfo());
    }

    private ApiInfo productApiInfo() {
        ApiInfo apiInfo = new ApiInfo("SMART 2代 API",
                "SMART 2代 API，所有应用程序都可以通过JSON访问Object模型数据。  \n" +
                        " 各个服务器状态接口:   \n" +
                        " 'http://localhost:9003/u-device/swagger-ui.html'  \n" +
                        " 智能的接口API地址:   \n" +
                        " 'http://localhost:9003/u-wisdom/swagger-ui.html'  \n" +
                        " 请求详细说明请查看 ‘智能家居_协议说明文档_V2.4+’",
                "2.0.0",
                "UUSmart服务条款",
                "386740421@qq.com",
                "The Apache License, Version 2.0",
                "https://github.com/LiangCan/UUSmart");
        return apiInfo;
    }
}