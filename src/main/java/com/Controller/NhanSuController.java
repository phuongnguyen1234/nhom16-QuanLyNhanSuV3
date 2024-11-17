package com.Controller;

import com.Service.*;
import com.Repository.*;
import com.Model.*;
import com.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import jakarta.servlet.http.*;


@RestController
@RequestMapping("/api/hoso")
public class NhanSuController {

    @Autowired
    private NhanSuService nhanSuService;

    @Autowired
    private NhanSuRepo nhanSuRepo;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private ViTriService viTriService;

    // Lấy danh sách chức vụ theo mã phòng ban
    @GetMapping("/{maPhongBan}/chucvu")
    public List<ChucVu> layChucVuTheoPhongBan(@PathVariable String maPhongBan) {
        return chucVuService.layChucVuTheoPhongBan(maPhongBan);
    }

    // Lấy danh sách vị trí theo mã chức vụ và mã phòng ban
    @GetMapping("/{maPhongBan}/{maChucVu}/vitri")
    public List<ViTri> layViTriTheoPhongBanVaChucVu(@PathVariable String maPhongBan, @PathVariable String maChucVu) {
        return viTriService.layViTriTheoPhongBanVaChucVu(maPhongBan, maChucVu);
    }

    @GetMapping("/all")
    public List<NhanSuShortDTO> layTatCaHoSo() {
        List<NhanSu> danhSachNhanSu = nhanSuService.layTatCaHoSo();
        List<NhanSuShortDTO> danhSachDTO = new ArrayList<>();

        for (NhanSu nhanSu : danhSachNhanSu) {
            NhanSuShortDTO dto = new NhanSuShortDTO(
                nhanSu.getMaNhanSu(),
                nhanSu.getTenNhanSu(),
                nhanSu.getPhongBan().getTenPhongBan(),
                nhanSu.getChucVu().getTenChucVu(),
                nhanSu.getViTri().getTenViTri()
            );
            danhSachDTO.add(dto);
        }

        return danhSachDTO;
    }

    @GetMapping("/{maNhanSu}")
    public ResponseEntity<NhanSuFullDTO> layHoSoChiTiet(@PathVariable String maNhanSu) {
    NhanSu nhanSu = nhanSuRepo.findById(maNhanSu).orElse(null);
    if (nhanSu == null) {
        return ResponseEntity.notFound().build();
    }
    // Chuyển đổi sang NhanSuFullDTO
    NhanSuFullDTO dto = new NhanSuFullDTO();
    dto.setMaNhanSu(nhanSu.getMaNhanSu());
    dto.setTenNhanSu(nhanSu.getTenNhanSu());
    dto.setGioiTinh(nhanSu.getGioiTinh());
    DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    dto.setNgaySinh(nhanSu.getNgaySinh().format(fm));
    dto.setDiaChi(nhanSu.getDiaChi());
    dto.setSoDienThoai(nhanSu.getSoDienThoai());
    dto.setEmail(nhanSu.getEmail());
    dto.setTenPhongBan(nhanSu.getPhongBan().getTenPhongBan());
    dto.setTenChucVu(nhanSu.getChucVu().getTenChucVu());
    dto.setTenViTri(nhanSu.getViTri().getTenViTri());
    dto.setMucLuong(nhanSu.getMucLuong());
    dto.setMatKhau(nhanSu.getMatKhau());
    return ResponseEntity.ok(dto);
    }

    //tao ho so moi
    @PostMapping("/new")
    public ResponseEntity<NhanSu> taoHoSoMoi(@RequestBody NhanSu nhanSu) {
        try {
            String newMaNhanSu = nhanSuService.generateNewMaNhanSu();
            nhanSu.setMaNhanSu(newMaNhanSu);
            NhanSu nhanSuMoi = nhanSuRepo.save(nhanSu);
            return ResponseEntity.ok(nhanSuMoi);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //cap nhat ho so
    @PutMapping("/edit/{maNhanSu}")
    public ResponseEntity<NhanSu> capNhatHoSo(@PathVariable String maNhanSu, @RequestBody NhanSu nhanSu) {
        if (!nhanSuRepo.existsById(maNhanSu)) {
            return ResponseEntity.notFound().build();
        }
        nhanSu.setMaNhanSu(maNhanSu); // Thiết lập lại mã nhân sự
        NhanSu nhanSuCapNhat = nhanSuRepo.save(nhanSu); // Lưu lại thông tin cập nhật
        return ResponseEntity.ok(nhanSuCapNhat);
    }

    //xoa ho so
    @DeleteMapping("/delete/{maNhanSu}")
    public ResponseEntity<Void> xoaHoSo(@PathVariable String maNhanSu) {
        if (!nhanSuRepo.existsById(maNhanSu)) {
            return ResponseEntity.notFound().build();
        }
        nhanSuRepo.deleteById(maNhanSu);
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
