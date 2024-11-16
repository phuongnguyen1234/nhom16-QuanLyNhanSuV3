package com.Repository;

import com.Model.BangLuong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface BangLuongRepository extends JpaRepository<BangLuong, String> {

    @Query("SELECT bl FROM BangLuong bl " +
           "JOIN bl.bangChamCong bcc " +
           "WHERE MONTH(bcc.thoiGian) = :month AND YEAR(bcc.thoiGian) = :year")
    List<BangLuong> findByMonthAndYear(@Param("month") int month, @Param("year") int year);
}

