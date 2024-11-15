package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Model.*;
import java.util.*;

public interface NhanSuRepo extends JpaRepository<NhanSu, String> {
    NhanSu findByMaNhanSu(String maNhanSu);
    List<NhanSu> findByMaViTri(String maViTri);
    List<NhanSu> findByMaChucVu(String maChucVu);
    List<NhanSu> findByMaPhongBan(String maPhongBan);
    Optional<NhanSu> findTopByOrderByMaNhanSuDesc();
}