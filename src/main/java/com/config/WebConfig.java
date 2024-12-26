package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Khi truy cập vào URL "/", chuyển hướng đến trang đăng nhập
        registry.addViewController("/").setViewName("pages-login"); // Đảm bảo 'pages-login' là tên tệp HTML trong thư mục templates
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Cho phép tất cả các nguồn truy cập vào API
        registry.addMapping("/api/**")
                .allowedOrigins("http://127.0.0.1:5500") // Cấu hình nguồn frontend của bạn
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Các phương thức HTTP cho phép
                .allowedHeaders("*"); // Cho phép tất cả các header
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/**") // Áp dụng cho tất cả các URL
                .excludePathPatterns("/pages-login.html", "/assets/**"); // Loại trừ URL không cần kiểm tra
    }

     @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0) // Không cache
                .setCacheControl(org.springframework.http.CacheControl.noStore()); // Ngăn cache
    }
}
