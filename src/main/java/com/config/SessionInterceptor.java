package com.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // Kiểm tra URL yêu cầu
        String uri = request.getRequestURI();

        // Bỏ qua kiểm tra session cho trang đăng nhập và tài nguyên tĩnh
        if (uri.equals("/pages-login.html") || uri.startsWith("/assets/") || uri.startsWith("/api/dangnhap")) {
            return true; // Cho phép truy cập
        }

        // Thêm các tiêu đề HTTP để ngăn trình duyệt cache các trang được bảo vệ
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setHeader("Expires", "0"); // Proxies

        // Các trang cần bảo vệ, nếu người dùng chưa đăng nhập sẽ bị chuyển hướng
        if (uri.equals("/index.html") || uri.equals("/users-profile.html") || uri.equals("/profiles-management.html") || uri.equals("/tables-general.html") || uri.equals("/tables-data.html")) {
            // Kiểm tra session
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("email") != null) {
                return true; // Session hợp lệ, cho phép truy cập
            }

            // Nếu không có session, chuyển hướng về trang đăng nhập
            response.sendRedirect("/pages-login.html");
            return false;
        }

        return true;
    }
}

