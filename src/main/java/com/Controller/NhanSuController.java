package com.Controller;

import com.Service.*;
import com.Repository.*;
import com.Model.*;
import com.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/hoso")
public class NhanSuController {

    @Autowired
    private NhanSuService nhanSuService;

    @Autowired // Tiêm nhanSuRepo
    private NhanSuRepo nhanSuRepo;

    @Autowired
    private PhongBanService phongBanService;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private ViTriService viTriService;

    // Lấy danh sách tất cả phòng ban
    @GetMapping("/phongban")
    public List<PhongBan> layTatCaPhongBan() {
        try {
            return phongBanService.layTatCaPhongBan();
        } catch (Exception e) {
        // Log lỗi
            System.out.println("Lỗi khi lấy phòng ban: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Lỗi hệ thống", e);
        }
    }

    // Lấy danh sách chức vụ theo mã phòng ban
    @GetMapping("/chucvu/{maPhongBan}")
    public List<ChucVu> layChucVuTheoPhongBan(@PathVariable String maPhongBan) {
        return chucVuService.layChucVuTheoPhongBan(maPhongBan);
    }

    // Lấy danh sách vị trí theo mã chức vụ và mã phòng ban
    @GetMapping("/vitri/{maPhongBan}/{maChucVu}")
    public List<ViTri> layViTriTheoChucVu(@PathVariable String maPhongBan, @PathVariable String maChucVu) {
        return viTriService.layViTriTheoChucVu(maPhongBan, maChucVu);
    }

    @GetMapping
    public List<NhanSuDTO> layTatCaHoSo() {
        List<NhanSu> danhSachNhanSu = nhanSuService.layTatCaHoSo();
        List<NhanSuDTO> danhSachDTO = new ArrayList<>();

    for (NhanSu nhanSu : danhSachNhanSu) {
        NhanSuDTO dto = new NhanSuDTO();
        dto.setMaNhanSu(nhanSu.getMaNhanSu());
        dto.setTenNhanSu(nhanSu.getTenNhanSu());
        dto.setTenPhongBan(nhanSu.getPhongBan().getTenPhongBan()); // Lấy tên phòng ban
        dto.setTenChucVu(nhanSu.getChucVu().getTenChucVu()); // Lấy tên chức vụ
        dto.setTenViTri(nhanSu.getViTri().getTenViTri()); // Lấy tên vị trí
        danhSachDTO.add(dto);
    }

    return danhSachDTO;
    }

    @GetMapping("/{maNhanSu}")
    public ResponseEntity<NhanSuDTO> layHoSoChiTiet(@PathVariable String maNhanSu) {
    NhanSu nhanSu = nhanSuRepo.findById(maNhanSu).orElse(null);
    if (nhanSu == null) {
        return ResponseEntity.notFound().build();
    }

    // Chuyển đổi sang NhanSuDTO
    NhanSuDTO dto = new NhanSuDTO();
    dto.setMaNhanSu(nhanSu.getMaNhanSu());
    dto.setTenNhanSu(nhanSu.getTenNhanSu());
    dto.setGioiTinh(nhanSu.getGioiTinh());
    dto.setNgaySinh(nhanSu.getNgaySinh());
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

    @PostMapping
    public ResponseEntity<NhanSu> taoHoSoMoi(@RequestBody NhanSu nhanSu) {
        try {
            NhanSu nhanSuMoi = nhanSuRepo.save(nhanSu);
            return ResponseEntity.ok(nhanSuMoi);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{maNhanSu}")
    public ResponseEntity<NhanSu> capNhatHoSo(@PathVariable String maNhanSu, @RequestBody NhanSu nhanSu) {
        if (!nhanSuRepo.existsById(maNhanSu)) {
            return ResponseEntity.notFound().build();
        }
        nhanSu.setMaNhanSu(maNhanSu); // Thiết lập lại mã nhân sự
        NhanSu nhanSuCapNhat = nhanSuRepo.save(nhanSu); // Lưu lại thông tin cập nhật
        return ResponseEntity.ok(nhanSuCapNhat);
    }

    @DeleteMapping("/{maNhanSu}")
    public ResponseEntity<Void> xoaHoSo(@PathVariable String maNhanSu) {
        if (!nhanSuRepo.existsById(maNhanSu)) {
            return ResponseEntity.notFound().build();
        }
        nhanSuRepo.deleteById(maNhanSu);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/phongban/{maPhongBan}")
    public List<NhanSuDTO> layHoSoTheoPhongBan(@PathVariable String maPhongBan) {
        List<NhanSu> danhSachNhanSu = nhanSuService.layHoSoTheoPhongBan(maPhongBan);
        List<NhanSuDTO> danhSachDTO = new ArrayList<>();

        for (NhanSu nhanSu : danhSachNhanSu) {
            NhanSuDTO dto = new NhanSuDTO();
            dto.setMaNhanSu(nhanSu.getMaNhanSu());
            dto.setTenNhanSu(nhanSu.getTenNhanSu());
            dto.setTenPhongBan(nhanSu.getPhongBan().getTenPhongBan());
            dto.setTenChucVu(nhanSu.getChucVu().getTenChucVu());
            dto.setTenViTri(nhanSu.getViTri().getTenViTri());
            danhSachDTO.add(dto);
        }

        return danhSachDTO;
    }

        @GetMapping("/chucvu/{maChucVu}")
    public List<NhanSuDTO> layHoSoTheoChucVu(@PathVariable String maChucVu) {
        List<NhanSu> danhSachNhanSu = nhanSuService.layHoSoTheoChucVu(maChucVu);
        List<NhanSuDTO> danhSachDTO = new ArrayList<>();

        for (NhanSu nhanSu : danhSachNhanSu) {
            NhanSuDTO dto = new NhanSuDTO();
            dto.setMaNhanSu(nhanSu.getMaNhanSu());
            dto.setTenNhanSu(nhanSu.getTenNhanSu());
            dto.setTenPhongBan(nhanSu.getPhongBan().getTenPhongBan());
            dto.setTenChucVu(nhanSu.getChucVu().getTenChucVu());
            dto.setTenViTri(nhanSu.getViTri().getTenViTri());
            danhSachDTO.add(dto);
        }

        return danhSachDTO;
    }

    @GetMapping("/vitri/{maViTri}")
    public List<NhanSuDTO> layHoSoTheoViTri(@PathVariable String maViTri) {
        List<NhanSu> danhSachNhanSu = nhanSuService.layHoSoTheoViTri(maViTri);
        List<NhanSuDTO> danhSachDTO = new ArrayList<>();

        for (NhanSu nhanSu : danhSachNhanSu) {
            NhanSuDTO dto = new NhanSuDTO();
            dto.setMaNhanSu(nhanSu.getMaNhanSu());
            dto.setTenNhanSu(nhanSu.getTenNhanSu());
            dto.setTenPhongBan(nhanSu.getPhongBan().getTenPhongBan());
            dto.setTenChucVu(nhanSu.getChucVu().getTenChucVu());
            dto.setTenViTri(nhanSu.getViTri().getTenViTri());
            danhSachDTO.add(dto);
        }

        return danhSachDTO;
    }

    @GetMapping("/{maNhanSu}")
    public ResponseEntity<NhanSuDTO> timKiemNhanSu(@PathVariable String maNhanSu) {
        NhanSu nhanSu = nhanSuService.timKiemNhanSu(maNhanSu); // Tìm kiếm trong service
        if (nhanSu != null) {
            NhanSuDTO dto = new NhanSuDTO();
            dto.setMaNhanSu(nhanSu.getMaNhanSu());
            dto.setTenNhanSu(nhanSu.getTenNhanSu());
            dto.setTenPhongBan(nhanSu.getPhongBan().getTenPhongBan());
            dto.setTenChucVu(nhanSu.getChucVu().getTenChucVu());
            dto.setTenViTri(nhanSu.getViTri().getTenViTri());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build(); // Nếu không tìm thấy, trả về 404
        }
    }

}
