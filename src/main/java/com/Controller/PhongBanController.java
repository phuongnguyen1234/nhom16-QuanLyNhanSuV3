package com.Controller;

import com.Service.*;
import com.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/phongban")
public class PhongBanController {

    @Autowired
    private PhongBanService phongBanService;

    // Lấy danh sách tất cả phòng ban
    @GetMapping
    public List<PhongBan> layTatCaPhongBan() {
        try {
            System.out.println("Lay dc!");
            return phongBanService.layTatCaPhongBan();
        } catch (Exception e) {
            System.out.println("Lỗi khi lấy phòng ban: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Lỗi hệ thống", e);
        }
    }
    
}
