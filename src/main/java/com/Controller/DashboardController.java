package com.Controller;

import com.Service.DashboardService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/dashboard") // Đường dẫn cơ sở cho API Dashboard
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    // API trả về số liệu tổng hợp
    @GetMapping("/statistics")
    public Map<String, Integer> getStatistics() {
        return dashboardService.getStatistics();
    }

    
    @GetMapping("/ageStatistics")
    public Map<String, Integer> getAgeStatistics() {
        return dashboardService.getAgeStatistics();
    }

}