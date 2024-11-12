package com.Service;

import com.Repository.*;
import com.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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