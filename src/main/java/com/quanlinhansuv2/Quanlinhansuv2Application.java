package com.quanlinhansuv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.quanlinhansuv2.Repository") // Đảm bảo Spring Boot biết nơi chứa các repository
@EntityScan(basePackages = "com.quanlinhansuv2.Model") // Đảm bảo Spring Boot quét các thực thể trong package Model
public class Quanlinhansuv2Application {
    public static void main(String[] args) {
        SpringApplication.run(Quanlinhansuv2Application.class, args);
    }
}