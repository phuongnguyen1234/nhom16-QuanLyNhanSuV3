package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Cho phép tất cả các nguồn truy cập vào API
        registry.addMapping("/api/**")
                .allowedOrigins("http://127.0.0.1:5500") // Cấu hình nguồn frontend của bạn
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Các phương thức HTTP cho phép
                .allowedHeaders("*"); // Cho phép tất cả các header
    }
}

