package com.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.Service.XacThucService;

@Controller
public class DangNhapController {

    @Autowired
    private XacThucService xacThucService;

    // Hiển thị trang đăng nhập
    @GetMapping("/dangnhap")
public String showLoginPage(HttpSession session) {
    // Nếu người dùng đã đăng nhập, chuyển hướng tới trang chủ
    if (session.getAttribute("email") != null) {
        return "redirect:/index.html";  // Hoặc trả về tên view index.html
    }
    // Nếu chưa đăng nhập, hiển thị trang đăng nhập
    return "pages-login";  // Trả về trang login (HTML tĩnh hoặc template)
}



    // API đăng nhập
    @PostMapping("/api/dangnhap")
public ResponseEntity<?> dangNhap(@RequestBody Map<String, String> requestData, HttpSession session) {
    String username = requestData.get("username");
    String password = requestData.get("password");

    if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
        return ResponseEntity.badRequest().body(Map.of("message", "Dữ liệu không hợp lệ"));
    }

    boolean isValid = xacThucService.kiemTraThongTinDangNhap(username, password);
    if (isValid) {
        session.setAttribute("email", username);
        return ResponseEntity.ok().body(Map.of("message", "Đăng nhập thành công"));
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Tên đăng nhập hoặc mật khẩu không đúng"));
    }
}
    

    // API đăng xuất
    @GetMapping("/dangxuat")
    public RedirectView dangXuat(HttpSession session, HttpServletResponse response) {
        // Xóa thông tin người dùng khỏi session khi đăng xuất
        session.invalidate();

        // Xóa cookie JSESSIONID (nếu có) để đảm bảo người dùng không còn session
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);  // Xóa cookie ngay lập tức
        cookie.setPath("/");  // Đảm bảo cookie bị xóa trên tất cả các path
        response.addCookie(cookie);

        // Chuyển hướng về trang đăng nhập
        return new RedirectView("/pages-login.html");
    }
}
