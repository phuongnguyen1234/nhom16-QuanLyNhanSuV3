package com.Service;

import com.Repository.*;
import java.util.*;
import com.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViTriService {
    @Autowired
    private ViTriRepo viTriRepo;

    public List<ViTri> layViTriTheoChucVu(String maPhongBan, String maChucVu) {
        return viTriRepo.findByMaPhongBanAndMaChucVu(maPhongBan, maChucVu);
    }
}
