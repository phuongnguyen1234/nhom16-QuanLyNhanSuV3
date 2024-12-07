package com.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.Model.NhanSu;
import com.Repository.NhanSuRepo;

@Service
public class DashboardService {

    private final NhanSuRepo nhanSuRepo;

    public DashboardService(NhanSuRepo nhanSuRepo) {
        this.nhanSuRepo = nhanSuRepo;
    }

    // Phương thức trả về danh sách tất cả nhân sự
    public List<NhanSu> getAllNhanSu() {
        return nhanSuRepo.findAll();
    }

    // Phương thức trả về danh sách nhân sự theo phòng ban
    public List<NhanSu> getUsersByDepartment(String maPhongBan) {
        return nhanSuRepo.findByMaPhongBan(maPhongBan);
    }

    // Phương thức tính toán số liệu tổng hợp cho Dashboard
    public Map<String, Integer> getStatistics() {
        Map<String, Integer> statistics = new HashMap<>();

        // Tổng số nhân sự
        int totalEmployees = (int) nhanSuRepo.count();
        statistics.put("totalEmployees", totalEmployees);

        // Số nhân sự theo từng phòng ban
        statistics.put("statIT", getUsersByDepartment("IT").size());
        statistics.put("statMKT", getUsersByDepartment("MKT").size());
        statistics.put("statNS", getUsersByDepartment("NS").size());
        statistics.put("statQHKH", getUsersByDepartment("QHKH").size());
        statistics.put("statTCKT", getUsersByDepartment("TC-KT").size());

        return statistics;
    }

    public Map<String, Integer> getAgeStatistics() {
        Map<String, Integer> ageStatistics = new HashMap<>();
        List<NhanSu> allNhanSu = nhanSuRepo.findAll();

        // Phân loại theo độ tuổi
        int ageUnder25 = 0;
        int age25To35 = 0;
        int age36To45 = 0;
        int ageAbove45 = 0;

        for (NhanSu nhanSu : allNhanSu) {
            int age = nhanSu.getAge(); // Giả sử bạn có thuộc tính `age` trong entity `NhanSu`
            if (age < 25) {
                ageUnder25++;
            } else if (age >= 25 && age <= 35) {
                age25To35++;
            } else if (age >= 36 && age <= 45) {
                age36To45++;
            } else {
                ageAbove45++;
            }
        }

        // Đưa vào map
        ageStatistics.put("Under 25", ageUnder25);
        ageStatistics.put("25-35", age25To35);
        ageStatistics.put("36-45", age36To45);
        ageStatistics.put("Above 45", ageAbove45);

        return ageStatistics;
    }

}
