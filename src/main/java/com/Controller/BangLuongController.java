package com.Controller;

import com.Model.BangLuong;
import com.Service.BangLuongService;
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
    public ResponseEntity<List<BangLuong>> getBangLuongByMonthAndYear(@RequestParam String month, @RequestParam String year) {
        try {
            // Check if month and year are valid integers
            int parsedMonth = Integer.parseInt(month);
            int parsedYear = Integer.parseInt(year);

            // Call service method to get data
            List<BangLuong> bangLuongs = bangLuongService.getBangLuongByMonth(parsedMonth, parsedYear);
            return ResponseEntity.ok(bangLuongs);

        } catch (NumberFormatException e) {
            // Handle invalid month/year format
            return ResponseEntity.badRequest().body(Collections.emptyList()); // or return error message
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

    // API để xuất bảng lương dưới dạng CSV
    @GetMapping("/export/csv")
    public ResponseEntity<String> exportBangLuongCsv() {
        List<BangLuong> bangLuongs = bangLuongService.exportBangLuong();
        if (bangLuongs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }


        StringBuilder csvOutput = new StringBuilder();
        csvOutput.append("MaBangLuong,TongThuNhap,LuongThucNhan,GhiChu,Month,Year\n");

        for (BangLuong bangLuong : bangLuongs) {

            csvOutput.append(bangLuong.getMaChucVuaBangLuong()).append(",")
                    .append(bangLuong.getTongThuNhap()).append(",")
                    .append(bangLuong.getLuongThucNhan()).append(",")
                    .append(bangLuong.getGhiChu()).append(",")
                    .append(bangLuong.getMonth()).append(",")
                    .append(bangLuong.getYear()).append("\n");
        }

        return ResponseEntity.ok()
                .header("Content-Type", "text/csv")
                .header("Content-Disposition", "attachment; filename=\"bangluong.csv\"")
                .body(csvOutput.toString());
    }
}
