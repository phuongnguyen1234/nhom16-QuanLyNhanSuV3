package com.Controller;

import com.Model.BangLuong;
import com.Model.BangChamCong;
import com.Service.BangLuongService;
import com.Service.BangChamCongService;  // Giả sử có service cho BangChamCong
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/bangluong")
public class BangLuongController {

    @Autowired
    private BangLuongService bangLuongService;

    @Autowired
    private BangChamCongService bangChamCongService; // Service cho BangChamCong

    @GetMapping("/all")
    public ResponseEntity<List<BangLuong>> getAllBangLuong() {
        List<BangLuong> bangLuongs = bangLuongService.getAllBangLuong();
        if (bangLuongs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bangLuongs);
    }

    // API để lọc bảng lương theo tháng và năm
   @GetMapping("/filter")
    public ResponseEntity<List<BangLuong>> getBangLuongByMonthAndYear(
            @RequestParam int month, @RequestParam int year) {
        try {
            // Lọc bảng lương theo tháng và năm
            List<BangLuong> bangLuongs = bangLuongService.filterByMonthAndYear(month, year);
            if (bangLuongs.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(bangLuongs);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.emptyList());
        }
    }


    @GetMapping("/export")
    public ResponseEntity<List<BangLuong>> exportBangLuong() {
        List<BangLuong> bangLuongs = bangLuongService.exportBangLuong();
        if (bangLuongs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bangLuongs);
    }

    // API xuất bảng lương dưới dạng CSV
    @GetMapping("/export/csv")
    public ResponseEntity<String> exportBangLuongCsv() {
        List<BangLuong> bangLuongs = bangLuongService.exportBangLuong();
        if (bangLuongs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        StringBuilder csvOutput = new StringBuilder();
        csvOutput.append("MaBangLuong,MaBangChamCong,TenNhanSu,Thang,SoNgayLamTrongThang,SoNgayNghi,LuongThucNhan,GhiChu\n");

        for (BangLuong bangLuong : bangLuongs) {
            BangChamCong bangChamCong = bangLuong.getBangChamCong();
            String maBangChamCong = bangChamCong != null ? bangChamCong.getMaBangChamCong() : "N/A";
            String tenNhanSu = bangChamCong != null && bangChamCong.getNhanSu().getTenNhanSu() != null
                    ? bangChamCong.getNhanSu().getTenNhanSu() : "Chưa có tên nhân sự";
            int soNgayLamTrongThang = bangChamCong != null ? bangChamCong.getSoNgayLamTrongThang() : 0;
            int soNgayNghi = bangChamCong != null ? bangChamCong.getSoNgayNghiCoPhep() + bangChamCong.getSoNgayNghiKhongPhep() : 0;

            csvOutput.append(bangLuong.getMaChucVuaBangLuong()).append(",")
                    .append(maBangChamCong).append(",")
                    .append(tenNhanSu).append(",")
                    .append(bangLuong.getMonth()).append(",")
                    .append(soNgayLamTrongThang).append(",")
                    .append(soNgayNghi).append(",")
                    .append(bangLuong.getLuongThucNhan()).append(",")
                    .append(bangLuong.getGhiChu()).append("\n");
        }

        return ResponseEntity.ok()
                .header("Content-Type", "text/csv")
                .header("Content-Disposition", "attachment; filename=\"bangluong.csv\"")
                .body(csvOutput.toString());
    }
}
