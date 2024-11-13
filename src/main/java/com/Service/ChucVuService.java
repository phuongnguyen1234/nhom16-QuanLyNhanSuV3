package com.Service;

import com.Model.*;
import com.Repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChucVuService {

    @Autowired
    private ChucVuRepo chucVuRepo;

    public List<ChucVu> layChucVuTheoPhongBan(String maPhongBan) {
        return chucVuRepo.findByPhongBan_MaPhongBan(maPhongBan);
    }
}
