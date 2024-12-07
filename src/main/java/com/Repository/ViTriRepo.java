package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Model.ViTri;
import com.Model.ViTriId;
;

@Repository
public interface ViTriRepo extends JpaRepository<ViTri, ViTriId> {
    List<ViTri> findByMaPhongBanAndMaChucVu(String maPhongBan, String maChucVu);
}
