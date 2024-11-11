package com.QLNS.project.Controller;

import com.QLNS.project.Model.BangChamCong;
import com.QLNS.project.DTO.BangChamCongDTO;
import com.QLNS.project.Service.BangChamCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    // Thêm bảng chấm công
    @PostMapping
    public BangChamCongDTO createBangChamCong(@RequestBody BangChamCongDTO bangChamCongDTO) {
        BangChamCong bangChamCong = convertToEntity(bangChamCongDTO);
        BangChamCong savedBangChamCong = bangChamCongService.saveBangChamCong(bangChamCong);
        return convertToDTO(savedBangChamCong);
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
