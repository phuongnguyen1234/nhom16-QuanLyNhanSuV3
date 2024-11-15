package com.Controller;

import com.Model.BangChamCong;
import com.Service.BangChamCongService;
import com.DTO.BangChamCongDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/bangchamcong")
public class BangChamCongController {

    @Autowired
    private BangChamCongService bangChamCongService;

    // Lấy danh sách bảng chấm công
    @GetMapping
    public List<BangChamCongDTO> getAllBangChamCong() {
        List<BangChamCong> bangChamCongList = bangChamCongService.getAllBangChamCong();
        return bangChamCongList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Lấy bảng chấm công theo mã
    @GetMapping("/{id}")
    public ResponseEntity<BangChamCongDTO> getBangChamCongById(@PathVariable String id) {
        Optional<BangChamCong> bangChamCong = bangChamCongService.getBangChamCongById(id);
        return bangChamCong.map(bang -> ResponseEntity.ok(convertToDTO(bang)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/export/excel")
    public ResponseEntity<InputStreamResource> exportBangChamCongToExcel() {
        ByteArrayInputStream in = bangChamCongService.exportBangChamCongToExcel();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=bangchamcong.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(in));
    }

    // Thêm bảng chấm công mới
    @PostMapping("/create")
    public ResponseEntity<?> createBangChamCong(@RequestBody BangChamCongDTO bangChamCongDTO) {
        try {
            BangChamCong bangChamCong = convertToEntity(bangChamCongDTO);
            BangChamCong savedBangChamCong = bangChamCongService.createBangChamCong(bangChamCong);
            return ResponseEntity.ok(convertToDTO(savedBangChamCong));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Cập nhật bảng chấm công
    @PutMapping("/{id}")
    public ResponseEntity<BangChamCongDTO> updateBangChamCong(@PathVariable String id, @RequestBody BangChamCongDTO bangChamCongDTO) {
        Optional<BangChamCong> optionalBangChamCong = bangChamCongService.getBangChamCongById(id);
        if (optionalBangChamCong.isPresent()) {
            BangChamCong bangChamCong = optionalBangChamCong.get();
            bangChamCong.setSoNgayLamTrongThang(bangChamCongDTO.getSoNgayLamTrongThang());
            bangChamCong.setSoNgayNghiCoPhep(bangChamCongDTO.getSoNgayNghiCoPhep());
            bangChamCong.setSoNgayNghiKhongPhep(bangChamCongDTO.getSoNgayNghiKhongPhep());
            bangChamCong.setGhiChu(bangChamCongDTO.getGhiChu());
            bangChamCong.setDuocPhepChinhSua(bangChamCongDTO.isDuocPhepChinhSua());
            BangChamCong updated = bangChamCongService.saveBangChamCong(bangChamCong);
            return ResponseEntity.ok(convertToDTO(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Endpoint tìm kiếm bảng chấm công theo tháng và năm
    @GetMapping("/search")
    public List<BangChamCongDTO> searchBangChamCongByMonthAndYear(
            @RequestParam int month, @RequestParam int year) {

        List<BangChamCong> bangChamCongList = bangChamCongService.getBangChamCongByMonthAndYear(month, year);
        return bangChamCongList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    // Chuyển đổi từ BangChamCong thành BangChamCongDTO
    private BangChamCongDTO convertToDTO(BangChamCong bangChamCong) {
        return new BangChamCongDTO(
                bangChamCong.getMaBangChamCong(),
                bangChamCong.getMaNhanSu(),
                bangChamCong.getThoiGian(),
                bangChamCong.getSoNgayLamTrongThang(),
                bangChamCong.getSoNgayNghiCoPhep(),
                bangChamCong.getSoNgayNghiKhongPhep(),
                bangChamCong.getGhiChu(),
                bangChamCong.isDuocPhepChinhSua()
        );
    }

    // Chuyển đổi từ BangChamCongDTO thành BangChamCong
    private BangChamCong convertToEntity(BangChamCongDTO bangChamCongDTO) {
        return new BangChamCong(
                bangChamCongDTO.getMaBangChamCong(),
                bangChamCongDTO.getMaNhanSu(),
                bangChamCongDTO.getThoiGian(),
                bangChamCongDTO.getSoNgayLamTrongThang(),
                bangChamCongDTO.getSoNgayNghiCoPhep(),
                bangChamCongDTO.getSoNgayNghiKhongPhep(),
                bangChamCongDTO.getGhiChu(),
                bangChamCongDTO.isDuocPhepChinhSua()
        );
    }
}
