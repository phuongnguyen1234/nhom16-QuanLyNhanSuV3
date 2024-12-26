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
import java.time.*;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/bangchamcong")
public class BangChamCongController {

    @Autowired
    private BangChamCongService bangChamCongService;

    // 1. Get all attendance records
    @GetMapping("/all")
    public List<BangChamCongDTO> getAllBangChamCong() {
        List<BangChamCong> bangChamCongList = bangChamCongService.getAllBangChamCong();
        return bangChamCongList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // 2. Get an attendance record by ID
    @GetMapping("/{id}")
    public ResponseEntity<BangChamCongDTO> getBangChamCongById(@PathVariable String id) {
        Optional<BangChamCong> bangChamCong = bangChamCongService.getBangChamCongById(id);
        return bangChamCong.map(bang -> ResponseEntity.ok(convertToDTO(bang)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3. Export all attendance records to Excel
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

    // 4. Create a new attendance record
    @PostMapping("/create")
    public ResponseEntity<?> createBangChamCong(@RequestBody BangChamCongDTO bangChamCongDTO) {
        try {
            // Log the received data
            System.out.println("Received BangChamCong DTO: " + bangChamCongDTO);

            // Convert DTO to Entity
            BangChamCong bangChamCong = convertToEntity(bangChamCongDTO);

            // Save the entity
            BangChamCong savedBangChamCong = bangChamCongService.createBangChamCong(bangChamCong);

            // Return the saved record as DTO
            return ResponseEntity.ok(convertToDTO(savedBangChamCong));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 5. Update an attendance record by ID
    @PutMapping("/{id}")
    public ResponseEntity<BangChamCongDTO> updateBangChamCong(@PathVariable String id, @RequestBody BangChamCongDTO bangChamCongDTO) {
        Optional<BangChamCong> optionalBangChamCong = bangChamCongService.getBangChamCongById(id);
        if (optionalBangChamCong.isPresent()) {
            BangChamCong bangChamCong = optionalBangChamCong.get();

            // Update fields with new values from DTO
            bangChamCong.setSoNgayLamTrongThang(bangChamCongDTO.getSoNgayLamTrongThang());
            bangChamCong.setSoNgayNghiCoPhep(bangChamCongDTO.getSoNgayNghiCoPhep());
            bangChamCong.setSoNgayNghiKhongPhep(bangChamCongDTO.getSoNgayNghiKhongPhep());
            bangChamCong.setSoGioLamThem(bangChamCongDTO.getSoGioLamThem());  // Update overtime hours
            bangChamCong.setGhiChu(bangChamCongDTO.getGhiChu());

            // Save updated attendance record
            BangChamCong updatedBangChamCong = bangChamCongService.saveBangChamCong(bangChamCong);

            // Return the updated record as DTO
            return ResponseEntity.ok(convertToDTO(updatedBangChamCong));
        }
        return ResponseEntity.notFound().build();  // Record not found
    }

    // 6. Search for attendance records by time (e.g., month and year)
//    @GetMapping("/search")
//    public List<BangChamCongDTO> searchBangChamCongByThoiGian(@RequestParam LocalDate thoiGian) {
//        List<BangChamCong> bangChamCongList = bangChamCongService.getBangChamCongByThoiGian(thoiGian);
//        return bangChamCongList.stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
    @GetMapping("/search")
    public List<BangChamCongDTO> searchBangChamCongByThoiGian(
            @RequestParam int month,
            @RequestParam int year) {
        List<BangChamCong> bangChamCongList = bangChamCongService.getBangChamCongByMonthAndYear(month, year);
        return bangChamCongList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    // Convert from BangChamCong entity to BangChamCongDTO
    private BangChamCongDTO convertToDTO(BangChamCong bangChamCong) {
        return new BangChamCongDTO(
                bangChamCong.getMaBangChamCong(),
                bangChamCong.getMaNhanSu(),
                bangChamCong.getThoiGian(),
                bangChamCong.getSoNgayLamTrongThang(),
                bangChamCong.getSoNgayNghiCoPhep(),
                bangChamCong.getSoNgayNghiKhongPhep(),
                bangChamCong.getGhiChu(),
                bangChamCong.isDuocPhepChinhSua(),
                bangChamCong.getSoGioLamThem()  // Include overtime hours
        );
    }

    // Convert from BangChamCongDTO to BangChamCong entity
    private BangChamCong convertToEntity(BangChamCongDTO bangChamCongDTO) {
        return new BangChamCong(
                bangChamCongDTO.getMaBangChamCong(),
                bangChamCongDTO.getMaNhanSu(),
                bangChamCongDTO.getThoiGian(),
                bangChamCongDTO.getSoNgayLamTrongThang(),
                bangChamCongDTO.getSoNgayNghiCoPhep(),
                bangChamCongDTO.getSoNgayNghiKhongPhep(),
                bangChamCongDTO.getGhiChu(),
                bangChamCongDTO.isDuocPhepChinhSua(),
                bangChamCongDTO.getSoGioLamThem()  // Set overtime hours from DTO
        );
    }
}
