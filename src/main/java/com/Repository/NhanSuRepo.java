package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Model.*;
import java.util.*;

public interface NhanSuRepo extends JpaRepository<NhanSu, String> {
    NhanSu findByMaNhanSu(String maNhanSu);
    List<NhanSu> findByViTri_MaViTri(String maViTri);
    List<NhanSu> findByChucVu_MaChucVu(String maChucVu);
    List<NhanSu> findByPhongBan_MaPhongBan(String maPhongBan);
    Optional<NhanSu> findTopByOrderByMaNhanSuDesc();
}