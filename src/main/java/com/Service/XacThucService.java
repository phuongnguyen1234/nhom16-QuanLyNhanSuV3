package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Model.NhanSu;
import com.Repository.NhanSuRepo;

@Service
public class XacThucService {

    @Autowired
    private NhanSuRepo nhanSuRepo;

    // Phương thức kiểm tra thông tin đăng nhập
    public boolean kiemTraThongTinDangNhap(String email, String matKhau) {
        NhanSu nhanSu = nhanSuRepo.findByEmail(email); // Tìm nhân sự theo email
        if (nhanSu != null) {
            // So sánh mật khẩu nhập vào với mật khẩu trong cơ sở dữ liệu
            if (matKhau != null && matKhau.equals(nhanSu.getMatKhau())) {
                return true;
            }
        }
        return false; // Nếu không tìm thấy nhân sự hoặc mật khẩu sai, trả về false
    }
}

