package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.NhanSu;
import Repository.NhanSuRepo;
import java.util.List;

@Service
public class NhanSuService {

    @Autowired
    private NhanSuRepo nhanSuRepository;

    public List<NhanSu> layTatCaHoSo() {
        return nhanSuRepository.findAll();
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
        return nhanSuRepo.findByMaNhanSu(maNhanSu); // Giả sử bạn đã định nghĩa phương thức này trong repository
    }
    
}
