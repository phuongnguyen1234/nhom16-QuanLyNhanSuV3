package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Model.*;

public interface BangChamCongRepo extends JpaRepository<BangChamCong, String> {
    
}