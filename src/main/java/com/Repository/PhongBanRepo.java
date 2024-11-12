package com.Repository;

import com.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;;


@Repository
public interface PhongBanRepo extends JpaRepository<PhongBan, String> {
}
