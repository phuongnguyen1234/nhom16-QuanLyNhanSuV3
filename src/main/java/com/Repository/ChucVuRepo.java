package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Model.ChucVu;
import com.Model.ChucVuId;

@Repository
public interface ChucVuRepo extends JpaRepository<ChucVu, ChucVuId> {
    List<ChucVu> findByMaPhongBan(String maPhongBan);
}
