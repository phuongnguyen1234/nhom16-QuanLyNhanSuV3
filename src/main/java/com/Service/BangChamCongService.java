package com.Service;

import com.Repository.BangChamCongRepo;
import com.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class BangChamCongService {

    @Autowired
    private BangChamCongRepo bangChamCongRepo;

    // Lấy tất cả danh sách bảng chấm công
    public List<BangChamCong> getAllBangChamCong() {
        return bangChamCongRepo.findAll();
    }

    // Lấy bảng chấm công theo mã
    public Optional<BangChamCong> getBangChamCongById(String maBangChamCong) {
        return bangChamCongRepo.findById(maBangChamCong);
    }
    // Thêm bảng chấm công nếu mã chưa tồn tại
    public BangChamCong createBangChamCong(BangChamCong bangChamCong) {
        if (bangChamCongRepo.existsById(bangChamCong.getMaBangChamCong())) {
            throw new IllegalArgumentException("Mã bảng chấm công đã tồn tại.");
        }
        BangChamCong savedBangChamCong = bangChamCongRepo.save(bangChamCong);
        System.out.println("Bảng chấm công đã được lưu: " + savedBangChamCong);
        return savedBangChamCong;
    }

    // Thêm hoặc cập nhật bảng chấm công
    public BangChamCong saveBangChamCong(BangChamCong bangChamCong) {
        return bangChamCongRepo.save(bangChamCong);
    }

    public ByteArrayInputStream exportBangChamCongToExcel() {
        String[] columns = {"Mã Bảng Chấm Công", "Mã Nhân Sự", "Thời Gian", "Số Ngày Làm Trong Tháng",
                "Số Ngày Nghỉ Có Phép", "Số Ngày Nghỉ Không Phép", "Ghi Chú", "Được Phép Chỉnh Sửa"};

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("BangChamCong");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }

            List<BangChamCong> bangChamCongList = getAllBangChamCong();
            int rowIdx = 1;
            for (BangChamCong bangChamCong : bangChamCongList) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(bangChamCong.getMaBangChamCong());
                row.createCell(1).setCellValue(bangChamCong.getMaNhanSu());
                row.createCell(2).setCellValue(bangChamCong.getThoiGian().toString());
                row.createCell(3).setCellValue(bangChamCong.getSoNgayLamTrongThang());
                row.createCell(4).setCellValue(bangChamCong.getSoNgayNghiCoPhep());
                row.createCell(5).setCellValue(bangChamCong.getSoNgayNghiKhongPhep());
                row.createCell(6).setCellValue(bangChamCong.getGhiChu());
                row.createCell(7).setCellValue(bangChamCong.isDuocPhepChinhSua());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Failed to export data to Excel file", e);
        }
    }
    // Hàm tìm kiếm bảng chấm công theo tháng và năm
    public List<BangChamCong> getBangChamCongByThoiGian(LocalDate thoiGian) {
        return bangChamCongRepo.findByThoiGian(thoiGian);
    }

    public boolean existsByMaNhanSu(String maNhanSu){
        return bangChamCongRepo.existsByMaNhanSu(maNhanSu);
    }
}
