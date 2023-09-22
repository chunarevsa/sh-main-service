package com.socialhobbies.shmainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories("com.socialhobbies.shmainservice.repo")
public class ShMainServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShMainServiceApplication.class, args);
    }

}
