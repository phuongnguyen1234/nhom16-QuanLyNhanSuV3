package com.QLNS.project.Service;

import com.QLNS.project.Model.BangChamCong;
import com.QLNS.project.Respository.BangChamCongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BangChamCongService {

    @Autowired
    private BangChamCongRepo bangChamCongRepo;

    // Lấy tất cả danh sách bảng chấm công
    public List<BangChamCong> getAllBangChamCong() {
        return bangChamCongRepo.findAll();
    }

    // Lấy bảng chấm công theo mã
    public Optional<BangChamCong> getBangChamCongById(String maBangChamCong) {
        return bangChamCongRepo.findById(maBangChamCong);
    }

    // Thêm hoặc cập nhật bảng chấm công
    public BangChamCong saveBangChamCong(BangChamCong bangChamCong) {
        return bangChamCongRepo.save(bangChamCong);
    }
}