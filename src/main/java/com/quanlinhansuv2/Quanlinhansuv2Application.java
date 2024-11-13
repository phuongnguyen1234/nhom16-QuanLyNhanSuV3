package com.quanlinhansuv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.Controller", "com.Service", "com.Repository"})
@EnableJpaRepositories(basePackages = "com.Repository")
@EntityScan(basePackages = "com.Model") 
public class Quanlinhansuv2Application {
    public static void main(String[] args) {
        SpringApplication.run(Quanlinhansuv2Application.class, args);
    }
}