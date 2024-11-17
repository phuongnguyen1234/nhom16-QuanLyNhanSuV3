package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Model.NhanSu;
import com.Service.NhanSuService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class TrangChuController {

     @Autowired
    private NhanSuService nhanSuService;

    // Trang chủ (Chỉ cho phép người dùng đã đăng nhập mới có thể vào)
    @GetMapping("/index.html")
    public String showHomePage(HttpSession session, Model model, HttpServletResponse response) {
        // Cấu hình header để không lưu cache
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        // Kiểm tra xem người dùng đã đăng nhập chưa
        if (session.getAttribute("email") == null) {
            // Thêm thông báo vào model nếu người dùng chưa đăng nhập
            model.addAttribute("errorMessage", "Bạn cần đăng nhập để tiếp tục.");
            // Nếu chưa đăng nhập, chuyển hướng về trang đăng nhập và truyền thông báo
            return "redirect:/dangnhap?error=true";
        }
        return "index"; // Nếu đã đăng nhập, hiển thị trang chủ
    }

    // Trang quản lý thông tin cá nhân (Chỉ cho phép người dùng đã đăng nhập mới có thể vào)
    @GetMapping("/profile-management.html")
    public String showProfileManagementPage(HttpSession session, Model model, HttpServletResponse response) {
        // Cấu hình header để không lưu cache
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        if (session.getAttribute("email") == null) {
            model.addAttribute("errorMessage", "Bạn cần đăng nhập để tiếp tục.");
            return "redirect:/dangnhap?error=true";
        }
        return "profile-management"; // Nếu đã đăng nhập, hiển thị trang quản lý thông tin cá nhân
    }

    // Trang dữ liệu bảng (Chỉ cho phép người dùng đã đăng nhập mới có thể vào)
    @GetMapping("/tables-data.html")
    public String showTablesDataPage(HttpSession session, Model model, HttpServletResponse response) {
        // Cấu hình header để không lưu cache
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        if (session.getAttribute("email") == null) {
            model.addAttribute("errorMessage", "Bạn cần đăng nhập để tiếp tục.");
            return "redirect:/dangnhap?error=true";
        }
        return "tables-data"; // Nếu đã đăng nhập, hiển thị trang dữ liệu bảng
    }

    // Trang bảng tổng quát (Chỉ cho phép người dùng đã đăng nhập mới có thể vào)
    @GetMapping("/tables-general.html")
    public String showTablesGeneralPage(HttpSession session, Model model, HttpServletResponse response) {
        // Cấu hình header để không lưu cache
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        if (session.getAttribute("email") == null) {
            model.addAttribute("errorMessage", "Bạn cần đăng nhập để tiếp tục.");
            return "redirect:/dangnhap?error=true";
        }
        return "tables-general"; // Nếu đã đăng nhập, hiển thị trang bảng tổng quát
    }

    // Trang hồ sơ người dùng (Chỉ cho phép người dùng đã đăng nhập mới có thể vào)
    @GetMapping("/users-profile.html")
public String showUserProfilePage(HttpSession session, Model model, HttpServletResponse response) {
    // Cấu hình header để không lưu cache
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    // Kiểm tra xem người dùng đã đăng nhập chưa
    String email = (String) session.getAttribute("email");
    if (email == null) {
        model.addAttribute("errorMessage", "Bạn cần đăng nhập để tiếp tục.");
        return "redirect:/dangnhap?error=true";
    }

    // Lấy thông tin người dùng từ cơ sở dữ liệu
    NhanSu nhanSu = nhanSuService.findByEmail(email);
    if (nhanSu == null) {
        return "redirect:/error"; // Nếu không tìm thấy người dùng
    }

    // Thêm đối tượng nhanSu vào Model
    model.addAttribute("nhanSu", nhanSu);

    return "users-profile"; // Trả về trang users-profile.html
}

}
