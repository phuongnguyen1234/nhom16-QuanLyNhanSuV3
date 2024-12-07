package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Model.*;
import java.time.*;
import java.util.*;

public interface BangChamCongRepo extends JpaRepository<BangChamCong, String> {
    List<BangChamCong> findByThoiGian(LocalDate thoiGian);
    boolean existsByMaNhanSu(String maNhanSu);
}
