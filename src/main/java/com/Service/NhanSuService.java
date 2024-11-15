package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Model.*;
import com.Repository.*;
import java.util.*;

@Service
public class NhanSuService {
    @Autowired
    private NhanSuRepo nhanSuRepo;

    public List<NhanSu> layTatCaHoSo() {
        return nhanSuRepo.findAll();
    }

    public List<NhanSu> layHoSoTheoPhongBan(String maPhongBan) {
        return nhanSuRepo.findByMaPhongBan(maPhongBan);
    }

    public List<NhanSu> layHoSoTheoChucVu(String maChucVu) {
        return nhanSuRepo.findByMaChucVu(maChucVu);
    }
    
    public List<NhanSu> layHoSoTheoViTri(String maViTri) {
        return nhanSuRepo.findByMaViTri(maViTri);
    }
    
    public NhanSu timKiemNhanSu(String maNhanSu) {
        return nhanSuRepo.findByMaNhanSu(maNhanSu); 
    }

    public String generateNewMaNhanSu() {
        Optional<NhanSu> lastNhanSu = nhanSuRepo.findTopByOrderByMaNhanSuDesc();
        String newMaNhanSu = "NS0001";  // Giá trị mặc định nếu không có hồ sơ nào.
        if (lastNhanSu.isPresent()) {
            String lastMaNhanSu = lastNhanSu.get().getMaNhanSu();  // Lấy mã nhân sự cuối cùng.
            int lastNumber = Integer.parseInt(lastMaNhanSu.substring(2));  // Lấy phần số sau 'NS'.
            newMaNhanSu = String.format("NS%04d", lastNumber + 1);  // Sinh mã mới theo định dạng NSxxxx.
        }
        return newMaNhanSu;
    }
}
