package com.cuityk.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonServerApplication.class, args);
    }

}
