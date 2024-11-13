package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Model.*;
import com.Repository.*;
import java.util.List;

@Service
public class NhanSuService {
    @Autowired
    private NhanSuRepo nhanSuRepo;

    public List<NhanSu> layTatCaHoSo() {
        return nhanSuRepo.findAll();
    }

    public List<NhanSu> layHoSoTheoPhongBan(String maPhongBan) {
        return nhanSuRepo.findByPhongBan_MaPhongBan(maPhongBan);
    }

    public List<NhanSu> layHoSoTheoChucVu(String maChucVu) {
        return nhanSuRepo.findByChucVu_MaChucVu(maChucVu);
    }
    
    public List<NhanSu> layHoSoTheoViTri(String maViTri) {
        return nhanSuRepo.findByViTri_MaViTri(maViTri);
    }
    
    public NhanSu timKiemNhanSu(String maNhanSu) {
        return nhanSuRepo.findByMaNhanSu(maNhanSu); 
    }
    
}
