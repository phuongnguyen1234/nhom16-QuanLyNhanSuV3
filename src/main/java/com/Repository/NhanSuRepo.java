package com.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.Model.*;
import java.util.*;

@Repository
public interface NhanSuRepo extends JpaRepository<NhanSu, String> {
    NhanSu findByMaNhanSu(String maNhanSu);
    List<NhanSu> findByMaViTri(String maViTri);
    List<NhanSu> findByMaChucVu(String maChucVu);
    List<NhanSu> findByMaPhongBan(String maPhongBan);
    Optional<NhanSu> findTopByOrderByMaNhanSuDesc();
    @Query("SELECT pb.tenPhongBan, COUNT(ns) " +
           "FROM NhanSu ns JOIN ns.phongBan pb " +
           "GROUP BY pb.tenPhongBan")
    List<Object[]> countNhanSuByPhongBan();

    long count();
}