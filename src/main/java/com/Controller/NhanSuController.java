package com.Controller;

import com.Service.*;
import com.Repository.*;
import com.Model.*;
import com.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;

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
    DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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

    //thong ke nhan su
    @GetMapping("/thongke")
    public Map<String, Object> getNhanSuCount() {
        Map<String, Object> response = new HashMap<>();

        // Tổng số nhân sự
        Long total = nhanSuRepo.count();
        response.put("tongSoNhanSu", total);

        // Số nhân sự theo từng phòng ban
        List<Object[]> counts = nhanSuRepo.countNhanSuByPhongBan();
        List<Map<String, Object>> phongBanCounts = counts.stream().map(row -> {
            Map<String, Object> phongBanData = new HashMap<>();
            phongBanData.put("tenPhongBan", row[0]);
            phongBanData.put("soNhanSu", row[1]);
            return phongBanData;
        }).collect(Collectors.toList());
        response.put("soNhanSuTheoPhongBan", phongBanCounts);

        return response;
    }
}
