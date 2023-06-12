package com.smarthome.shmainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShMainServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShMainServiceApplication.class, args);
    }

}
