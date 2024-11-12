package com.Controller;

import com.Service.*;
import com.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/phongban")
public class PhongBanController {

    @Autowired
    private PhongBanService phongBanService;

    // Endpoint để lấy danh sách phòng ban
    @GetMapping
    public List<PhongBan> layTatCaPhongBan() {
        return phongBanService.layTatCaPhongBan();
    }
}
