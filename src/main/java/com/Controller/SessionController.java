package com.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class SessionController {

    @GetMapping("/check-session")
    public ResponseEntity<?> checkSession(HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (email != null) {
            // Nếu session tồn tại, trả về thông tin người dùng
            return ResponseEntity.ok("Session hợp lệ: " + email);
        } else {
            // Nếu session không tồn tại, trả về lỗi
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Session không hợp lệ");
        }
    }
}