package com.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.NhanSuDTO;
import com.Model.NhanSu;
import com.Repository.NhanSuRepo;
import com.Service.NhanSuService;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/api/hoso")
public class NhanSuController {

    @Autowired
    private NhanSuService nhanSuService;

    @Autowired
    private NhanSuRepo nhanSuRepo;

    @GetMapping("/all")
    public List<NhanSuDTO> layTatCaHoSo() {
        return nhanSuService.layTatCaHoSo();
    }

    @GetMapping("/{maNhanSu}")
    public ResponseEntity<NhanSuDTO> layHoSoChiTiet(@PathVariable String maNhanSu) {
        NhanSuDTO nhanSu = nhanSuService.layHoSoChiTiet(maNhanSu);
        return ResponseEntity.ok(nhanSu);
    }

    //tao ho so moi
    @PostMapping("/new")
    public ResponseEntity<NhanSu> taoHoSoMoi(@RequestBody NhanSu nhanSu) {
        try {
            nhanSu.setMaNhanSu(nhanSuService.generateNewMaNhanSu());
            NhanSu nhanSuMoi = nhanSuService.taoHoSoMoi(nhanSu);
            return ResponseEntity.ok(nhanSuMoi);
        } catch (Exception e) {
            e.printStackTrace(); // Log chi tiết lỗi
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    //cap nhat ho so
    @PutMapping("/edit/{maNhanSu}")
    public ResponseEntity<NhanSu> capNhatHoSo(@RequestBody NhanSu nhanSu) {
        if(nhanSu == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        NhanSu nhanSuUpdate = nhanSuService.capNhatHoSo(nhanSu);
        return ResponseEntity.ok(nhanSuUpdate);
    }


    //xoa ho so
    @DeleteMapping("/delete/{maNhanSu}")
    public ResponseEntity<Void> xoaHoSo(@PathVariable String maNhanSu) {
        nhanSuService.xoaHoSo(maNhanSu);
        return ResponseEntity.noContent().build();
    }

@GetMapping("/thongtinnguoidung")
@ResponseBody
public ResponseEntity<NhanSu> getUserProfile(HttpSession session) {
    String email = (String) session.getAttribute("email");
    if (email == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Trả về lỗi nếu chưa đăng nhập
    }

    NhanSu nhanSu = nhanSuService.findByEmail(email);
    if (nhanSu == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Trả về lỗi nếu không tìm thấy người dùng
    }

    return ResponseEntity.ok(nhanSu); // Trả về thông tin người dùng dưới dạng JSON
}


@PutMapping("/capnhat")
public ResponseEntity<NhanSu> capNhatThongTinHoSo(@RequestBody NhanSu nhanSu, HttpSession session) {
    String email = (String) session.getAttribute("email");
    if (email == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Trả về lỗi nếu chưa đăng nhập
    }

    NhanSu existingNhanSu = nhanSuService.findByEmail(email); // Tìm nhân sự theo email
    if (existingNhanSu == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Trả về lỗi nếu không tìm thấy nhân sự
    }

    // Cập nhật thông tin nhân sự
    existingNhanSu.setTenNhanSu(nhanSu.getTenNhanSu());
    existingNhanSu.setGioiTinh(nhanSu.getGioiTinh());
    existingNhanSu.setNgaySinh(nhanSu.getNgaySinh());
    existingNhanSu.setDiaChi(nhanSu.getDiaChi());
    existingNhanSu.setSoDienThoai(nhanSu.getSoDienThoai());

    NhanSu updatedNhanSu = nhanSuRepo.save(existingNhanSu); // Lưu lại thông tin cập nhật
    return ResponseEntity.ok(updatedNhanSu); // Trả về thông tin đã cập nhật
}

@PutMapping("/thaydoimatkhau")
public ResponseEntity<String> thayDoiMatKhau(@RequestBody Map<String, String> passwordData, HttpSession session) {
    String email = (String) session.getAttribute("email");
    if (email == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Chưa đăng nhập");
    }

    // Lấy mật khẩu cũ, mật khẩu mới từ dữ liệu gửi đến
    String matKhauCu = passwordData.get("matKhauCu");
    String matKhauMoi = passwordData.get("matKhauMoi");

    // Kiểm tra mật khẩu cũ (ví dụ: so sánh với mật khẩu hiện tại trong cơ sở dữ liệu)
    NhanSu nhanSu = nhanSuService.findByEmail(email);
    if (nhanSu == null || !nhanSu.getMatKhau().equals(matKhauCu)) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mật khẩu cũ không chính xác");
    }

    // Cập nhật mật khẩu mới vào cơ sở dữ liệu
    nhanSu.setMatKhau(matKhauMoi);
    nhanSuService.save(nhanSu);

    return ResponseEntity.ok("Mật khẩu đã được thay đổi thành công");
}

}
