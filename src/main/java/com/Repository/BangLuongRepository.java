package com.Repository;

import com.Model.BangLuong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BangLuongRepository extends JpaRepository<BangLuong, Integer> {
    List<BangLuong> findByMonthAndYear(int month, int year);
}
