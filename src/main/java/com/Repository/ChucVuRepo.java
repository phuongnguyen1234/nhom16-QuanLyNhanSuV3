package com.Repository;

import com.Model.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface ChucVuRepo extends JpaRepository<ChucVu, ChucVuId> {
    List<ChucVu> findByMaPhongBan(String maPhongBan);
}
