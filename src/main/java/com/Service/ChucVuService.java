package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.ChucVu;
import com.Repository.ChucVuRepo;

@Service
public class ChucVuService {
    @Autowired
    private ChucVuRepo chucVuRepo;

    public List<ChucVu> layChucVuTheoPhongBan(String maPhongBan) {
        return chucVuRepo.findByMaPhongBan(maPhongBan);
    }
}
