package com.Service;

import com.Model.BangLuong;
import com.Repository.BangLuongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BangLuongService {

    @Autowired
    private BangLuongRepository bangLuongRepository;

    // Hiển thị tất cả các bảng lương
    public List<BangLuong> getAllBangLuong() {
        return bangLuongRepository.findAll();
    }

    public List<BangLuong> filterByMonthAndYear(int month, int year) {
        return bangLuongRepository.findByBangChamCong_ThoiGian_MonthAndYear(month, year);
    }

    // Xuất bảng lương dưới dạng JSON
    public List<BangLuong> exportBangLuong() {
        return bangLuongRepository.findAll();
    }
}
