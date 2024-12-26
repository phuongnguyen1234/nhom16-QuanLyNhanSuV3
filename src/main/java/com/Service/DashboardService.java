package com.Service;

import com.Model.NhanSu;
import com.Repository.NhanSuRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        // Số nhân sự theo từng phòng ban (giả sử bạn có mã phòng ban như "A", "B", "C" trong cơ sở dữ liệu)
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


    
    // Thống kê phân chia theo mức lương
    public Map<String, Integer> getSalaryStatistics() {
        Map<String, Integer> salaryStatistics = new HashMap<>();
        List<NhanSu> allNhanSu = nhanSuRepo.findAll();

        // Khởi tạo các nhóm mức lương
        int under6M = 0;
        int between6MAnd9M = 0;
        int above9M = 0;

        // Phân loại theo mức lương
        for (NhanSu nhanSu : allNhanSu) {
            int salary = nhanSu.getMucLuong();
            if (salary < 6000000) {
                under6M++;
            } else if (salary >= 6000000 && salary <= 9000000) {
                between6MAnd9M++;
            } else {
                above9M++;
            }
        }

        salaryStatistics.put("Dưới 6 triệu", under6M);
        salaryStatistics.put("6-9 triệu", between6MAnd9M);
        salaryStatistics.put("Trên 9 triệu", above9M);

        return salaryStatistics;
    }
    


    //Thống kê mức lương và phân chia theo các phòng ban
    public Map<String, Map<String, Integer>> getDepartmentSalaryDistribution() {
        Map<String, Map<String, Integer>> distribution = new HashMap<>();
        List<NhanSu> allNhanSu = nhanSuRepo.findAll();
    
        // Duyệt qua từng phòng ban và nhóm mức lương
        for (NhanSu nhanSu : allNhanSu) {
            String department = nhanSu.getMaPhongBan();
            int salary = nhanSu.getMucLuong();
            String salaryGroup;
    
            if (salary < 6000000) {
                salaryGroup = "Dưới 6 triệu";
            } else if (salary <= 9000000) {
                salaryGroup = "6-9 triệu";
            } else {
                salaryGroup = "Trên 9 triệu";
            }
    
            // Khởi tạo map nếu chưa tồn tại
            distribution.putIfAbsent(department, new HashMap<>());
            Map<String, Integer> salaryMap = distribution.get(department);
    
            // Cập nhật số liệu
            salaryMap.put(salaryGroup, salaryMap.getOrDefault(salaryGroup, 0) + 1);
        }
    
        return distribution;
    }
    

    
}
