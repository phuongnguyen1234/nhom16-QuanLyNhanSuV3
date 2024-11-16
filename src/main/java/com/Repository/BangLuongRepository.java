package com.Repository;

import com.Model.BangLuong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BangLuongRepository extends JpaRepository<BangLuong, String> {
    List<BangLuong> findByBangChamCong_ThoiGian_MonthAndBangChamCong_ThoiGian_Year(int month, int year);
}


