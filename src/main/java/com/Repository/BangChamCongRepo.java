
package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.*;
import java.util.*;

public interface BangChamCongRepo extends JpaRepository<BangChamCong, String> {
    @Query("SELECT b FROM BangChamCong b WHERE MONTH(b.thoiGian) = :month AND YEAR(b.thoiGian) = :year")
    List<BangChamCong> findByMonthAndYear(@Param("month") int month, @Param("year") int year);
}
