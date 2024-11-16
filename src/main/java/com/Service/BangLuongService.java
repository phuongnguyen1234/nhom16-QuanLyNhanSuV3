package com.Service;

import com.Model.BangLuong;
import com.Repository.BangLuongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class BangLuongService {

    @Autowired
    private BangLuongRepo bangLuongRepository;

    // Hiển thị tất cả các bảng lương
    public List<BangLuong> getAllBangLuong() {
        return bangLuongRepository.findAll();
    }

    // Lọc bảng lương theo tháng
    public List<BangLuong> getBangLuongByThoiGian(LocalDate thoiGian) {
        return bangLuongRepository.findByThoiGian(thoiGian); //
    }

    // Xuất bảng lương dưới dạng JSON
    public List<BangLuong> exportBangLuong() {
        return bangLuongRepository.findAll();
    }
}
