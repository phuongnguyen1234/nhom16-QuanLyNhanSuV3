package com.Controller;

import com.Service.*;
import com.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vitricongviec")
public class ViTriCongViecController {

    @Autowired
    private PhongBanService phongBanService;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private ViTriService viTriService;

    // Lấy danh sách tất cả phòng ban
    @GetMapping("/all-phongban")
    public List<PhongBan> layTatCaPhongBan() {
        return phongBanService.layTatCaPhongBan();
    }

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
    
}
