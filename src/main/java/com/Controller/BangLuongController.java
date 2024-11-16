package com.Controller;

import com.DTO.*;
import com.Model.BangLuong;
import com.Model.BangChamCong;
import com.Service.BangLuongService;
import com.Service.BangChamCongService;  // Giả sử có service cho BangChamCong
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.*;

@RestController
@RequestMapping("/api/bangluong")
public class BangLuongController {

    @Autowired
    private BangLuongService bangLuongService;

    @GetMapping("/all")
    public List<BangLuongDTO> getAllBangLuong() {
        List<BangLuong> bangLuong = bangLuongService.getAllBangLuong();
        List<BangLuongDTO> danhSach = new ArrayList<>();
            for(BangLuong bl: bangLuong){
                BangLuongDTO dto = new BangLuongDTO(
                    bl.getMaBangLuong(),
                    bl.getBangChamCong().getMaBangChamCong(),
                    bl.getBangChamCong().getNhanSu().getTenNhanSu(),
                    bl.getBangChamCong().getNhanSu().getPhongBan().getTenPhongBan(),
                    bl.getBangChamCong().getNhanSu().getChucVu().getTenChucVu(),
                    bl.getBangChamCong().getNhanSu().getViTri().getTenViTri(),
                    bl.getBangChamCong().getThoiGian(),
                    bl.getBangChamCong().getSoNgayLamTrongThang(),
                    bl.getBangChamCong().getSoNgayNghiCoPhep(),
                    bl.getBangChamCong().getSoNgayNghiKhongPhep(),
                    bl.getTongThuNhap(),
                    bl.getLuongThucNhan(),
                    bl.getGhiChu()
                );
                danhSach.add(dto);
            }
            return danhSach;
    }
        

    // API để lọc bảng lương theo tháng và năm
    @GetMapping("/filter")
    public ResponseEntity<List<BangLuong>> getBangLuongByThoiGian(@RequestParam LocalDate thoiGian) {
        try {
            // Call service method to get data
            List<BangLuong> bangLuong = bangLuongService.getBangLuongByThoiGian(thoiGian);
            return ResponseEntity.ok(bangLuong);

        } catch (Exception e) {
            // Handle invalid month/year format
            return ResponseEntity.badRequest().body(Collections.emptyList()); // or return error message
        }
    }

    // API để xuất bảng lương dưới dạng CSV
    @GetMapping("/export/csv")
    public ResponseEntity<String> exportBangLuongCsv() {
        List<BangLuong> bangLuong = bangLuongService.exportBangLuong();
        if (bangLuong.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        StringBuilder csvOutput = new StringBuilder();
        csvOutput.append("MaBangLuong,MaBangChamCong,TenNhanSu,Thang,SoNgayLamTrongThang,SoNgayNghi,LuongThucNhan,GhiChu\n");

        for (BangLuong bl : bangLuong) {

            csvOutput.append(bl.getMaBangLuong()).append(",")
                    .append(bl.getTongThuNhap()).append(",")
                    .append(bl.getLuongThucNhan()).append(",")
                    .append(bl.getGhiChu()).append(",");
        }

        return ResponseEntity.ok()
                .header("Content-Type", "text/csv")
                .header("Content-Disposition", "attachment; filename=\"bangluong.csv\"")
                .body(csvOutput.toString());
    }
}
