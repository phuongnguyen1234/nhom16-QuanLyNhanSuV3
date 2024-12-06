package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        // Kiểm tra nếu người dùng đã đăng nhập, chuyển hướng đến trang chính
        if (session.getAttribute("email") != null) {
            return "redirect:/index.html";
        }
        return "pages-login"; // Trả về trang đăng nhập
    }

    // API đăng nhập
    @PostMapping("/dangnhap")
    public String dangNhap(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        // Kiểm tra thông tin đăng nhập
        boolean isValid = xacThucService.kiemTraThongTinDangNhap(username, password);

        if (isValid) {
            // Lưu thông tin người dùng vào session
            session.setAttribute("email", username);
            // Chuyển hướng người dùng tới trang index.html sau khi đăng nhập thành công
            return "redirect:/index.html";
        } else {
            // Thêm thông báo lỗi vào model và reload lại trang
            model.addAttribute("errorMessage", "Nhập sai thông tin, vui lòng nhập lại.");
            // Trả về trang đăng nhập với thông báo lỗi
            return "pages-login";
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
        return new RedirectView("/dangnhap");
    }
}
