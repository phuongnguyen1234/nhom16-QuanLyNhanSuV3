package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Model.*;
import java.util.List;
import org.springframework.stereotype.*;;

@Repository
public interface ViTriRepo extends JpaRepository<ViTri, ViTriId> {
    List<ViTri> findByMaPhongBanAndMaChucVu(String maPhongBan, String maChucVu);
}
