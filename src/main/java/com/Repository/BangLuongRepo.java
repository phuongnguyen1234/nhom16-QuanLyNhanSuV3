package com.Repository;

import com.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.*;
import java.util.List;

public interface BangLuongRepo extends JpaRepository<BangLuong, String> {
    @Query("SELECT bl FROM BangLuong bl JOIN bl.bangChamCong bcc WHERE bcc.thoiGian = :thoiGian")
    List<BangLuong> findByThoiGian(@Param("thoiGian") LocalDate thoiGian);
}
