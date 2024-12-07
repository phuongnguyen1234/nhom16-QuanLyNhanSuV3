package com.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.NhanSuDTO;
import com.Model.NhanSu;
import com.Repository.BangChamCongRepo;
import com.Repository.NhanSuRepo;

@Service
public class NhanSuService {
    @Autowired
    private NhanSuRepo nhanSuRepo;

    @Autowired
    private BangChamCongRepo bangChamCongRepo;

    public List<NhanSuDTO> layTatCaHoSo() { //lay danh sach ho so
        List<NhanSu> danhSachNhanSu = nhanSuRepo.findAll();
        List<NhanSuDTO> danhSachDTO = new ArrayList<>();
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (NhanSu ns : danhSachNhanSu) {
            NhanSuDTO dto = new NhanSuDTO(
                ns.getMaNhanSu(),
                ns.getTenNhanSu(),
                ns.getGioiTinh(),
                ns.getNgaySinh().format(fm),
                ns.getDiaChi(),
                ns.getSoDienThoai(),
                ns.getEmail(),
                ns.getMaPhongBan(),
                ns.getPhongBan().getTenPhongBan(),
                ns.getMaChucVu(),
                ns.getChucVu().getTenChucVu(),
                ns.getMaViTri(),
                ns.getViTri().getTenViTri(),
                ns.getMucLuong(),
                ns.getMatKhau());
            danhSachDTO.add(dto);
        }

        return danhSachDTO;
    }
    
    public NhanSuDTO layHoSoChiTiet(String maNhanSu){
        NhanSu ns = nhanSuRepo.findByMaNhanSu(maNhanSu);
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        NhanSuDTO dto = new NhanSuDTO(
            maNhanSu,
            ns.getTenNhanSu(),
            ns.getGioiTinh(),
            ns.getNgaySinh().format(fm),
            ns.getDiaChi(),
            ns.getSoDienThoai(),
            ns.getEmail(),
            ns.getMaPhongBan(),
            ns.getPhongBan().getTenPhongBan(),
            ns.getMaChucVu(),
            ns.getChucVu().getTenChucVu(),
            ns.getMaViTri(),
            ns.getViTri().getTenViTri(),
            ns.getMucLuong(),
            ns.getMatKhau()
            );
        return dto;
    }

    public String generateNewMaNhanSu() {
        // Lấy mã nhân sự cuối cùng từ cơ sở dữ liệu (sắp xếp giảm dần theo mã)
        Optional<NhanSu> lastNhanSu = nhanSuRepo.findTopByOrderByMaNhanSuDesc();
        String newMaNhanSu = "NS0001"; // Giá trị mặc định nếu không có hồ sơ nào
    
        if (lastNhanSu.isPresent()) {
            String lastMaNhanSu = lastNhanSu.get().getMaNhanSu(); // Lấy mã nhân sự cuối cùng
            try {
                int lastNumber = Integer.parseInt(lastMaNhanSu.substring(2)); // Lấy phần số sau 'NS'
                newMaNhanSu = String.format("NS%04d", lastNumber + 1); // Sinh mã mới theo định dạng NSxxxx
            } catch (NumberFormatException e) {
                // Xử lý trường hợp mã không đúng định dạng
                throw new IllegalStateException("Mã nhân sự không đúng định dạng: " + lastMaNhanSu, e);
            }
        }
    
        // Kiểm tra mã mới có tồn tại trong bảng công hoặc bảng khác liên quan
        while (isMaNhanSuUsedInBangChamCong(newMaNhanSu)) {
            // Nếu mã đã tồn tại, tăng số thứ tự và thử lại
            int currentNumber = Integer.parseInt(newMaNhanSu.substring(2));
            newMaNhanSu = String.format("NS%04d", currentNumber + 1);
        }
    
        return newMaNhanSu;
    }

    public NhanSu taoHoSoMoi(NhanSu nhanSu){
        NhanSu nhanSuMoi = nhanSuRepo.save(nhanSu);
        return nhanSuMoi;
    }
    
    // Kiểm tra mã nhân sự có tồn tại trong bảng công hay không
    private boolean isMaNhanSuUsedInBangChamCong(String maNhanSu) {
        return bangChamCongRepo.existsByMaNhanSu(maNhanSu); // Sử dụng phương thức từ repository
    }
    
    public Long getTotalNhanSu() {
        return nhanSuRepo.count();
    }

    public List<Map<String, Object>> getNhanSuCountByPhongBan() {
        List<Object[]> results = nhanSuRepo.countNhanSuByPhongBan();
        return results.stream().map(row -> {
            Map<String, Object> phongBanData = new HashMap<>();
            phongBanData.put("tenPhongBan", row[0]);
            phongBanData.put("soNhanSu", row[1]);
            return phongBanData;
        }).collect(Collectors.toList());
    }

    public NhanSu findByEmail(String email) {
        return nhanSuRepo.findByEmail(email); // Tìm nhân sự theo email
    }
    
    public NhanSu save(NhanSu nhanSu) {
        return nhanSuRepo.save(nhanSu);
    }

    public NhanSu capNhatHoSo(NhanSu nhanSu){
        NhanSu nhanSuUpdate = new NhanSu();
        nhanSuUpdate.setMaNhanSu(nhanSu.getMaNhanSu());
        nhanSuUpdate.setTenNhanSu(nhanSu.getTenNhanSu());
        nhanSuUpdate.setGioiTinh(nhanSu.getGioiTinh());
        nhanSuUpdate.setNgaySinh(nhanSu.getNgaySinh());
        nhanSuUpdate.setDiaChi(nhanSu.getDiaChi());
        nhanSuUpdate.setSoDienThoai(nhanSu.getSoDienThoai());
        nhanSuUpdate.setEmail(nhanSu.getEmail());
        nhanSuUpdate.setMaPhongBan(nhanSu.getMaPhongBan());
        nhanSuUpdate.setMaChucVu(nhanSu.getMaChucVu());
        nhanSuUpdate.setMaViTri(nhanSu.getMaViTri());
        nhanSuUpdate.setMucLuong(nhanSu.getMucLuong());
        nhanSuUpdate.setMatKhau(nhanSu.getMatKhau());

        return nhanSuRepo.save(nhanSuUpdate);
    }

    public void xoaHoSo(String maNhanSu){
        nhanSuRepo.deleteById(maNhanSu); // Xóa nhân sự theo mã nhân sự
    }

    public NhanSu findByMaNhanSu(String maNhanSu){
        return nhanSuRepo.findByMaNhanSu(maNhanSu);
    }

}
