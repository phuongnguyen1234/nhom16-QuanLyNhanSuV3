package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.ViTri;
import com.Repository.ViTriRepo;

@Service
public class ViTriService {
    @Autowired
    private ViTriRepo viTriRepo;

    public List<ViTri> layViTriTheoPhongBanVaChucVu(String maPhongBan, String maChucVu) {
        return viTriRepo.findByMaPhongBanAndMaChucVu(maPhongBan, maChucVu);
    }
}
