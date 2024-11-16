package com.DTO;

import java.time.LocalDate;

public class BangChamCongDTO {
    private String maBangChamCong;
    private String maNhanSu;
    private LocalDate thoiGian;
    private int soNgayLamTrongThang;
    private int soNgayNghiCoPhep;
    private int soNgayNghiKhongPhep;
    private String ghiChu;
    private boolean duocPhepChinhSua;

    public BangChamCongDTO() {
    }

    public BangChamCongDTO(String maBangChamCong, String maNhanSu, LocalDate thoiGian,
                           int soNgayLamTrongThang, int soNgayNghiCoPhep,
                           int soNgayNghiKhongPhep, String ghiChu, boolean duocPhepChinhSua) {
        this.maBangChamCong = maBangChamCong;
        this.maNhanSu = maNhanSu;
        this.thoiGian = thoiGian;
        this.soNgayLamTrongThang = soNgayLamTrongThang;
        this.soNgayNghiCoPhep = soNgayNghiCoPhep;
        this.soNgayNghiKhongPhep = soNgayNghiKhongPhep;
        this.ghiChu = ghiChu;
        this.duocPhepChinhSua = duocPhepChinhSua;
    }

    // Getters và Setters

    public String getMaBangChamCong() {
        return maBangChamCong;
    }

    public void setMaBangChamCong(String maBangChamCong) {
        this.maBangChamCong = maBangChamCong;
    }

    public String getMaNhanSu() {
        return maNhanSu;
    }

    public void setMaNhanSu(String maNhanSu) {
        this.maNhanSu = maNhanSu;
    }

    public LocalDate getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDate thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getSoNgayLamTrongThang() {
        return soNgayLamTrongThang;
    }

    public void setSoNgayLamTrongThang(int soNgayLamTrongThang) {
        this.soNgayLamTrongThang = soNgayLamTrongThang;
    }

    public int getSoNgayNghiCoPhep() {
        return soNgayNghiCoPhep;
    }

    public void setSoNgayNghiCoPhep(int soNgayNghiCoPhep) {
        this.soNgayNghiCoPhep = soNgayNghiCoPhep;
    }

    public int getSoNgayNghiKhongPhep() {
        return soNgayNghiKhongPhep;
    }

    public void setSoNgayNghiKhongPhep(int soNgayNghiKhongPhep) {
        this.soNgayNghiKhongPhep = soNgayNghiKhongPhep;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isDuocPhepChinhSua() {
        return duocPhepChinhSua;
    }

    public void setDuocPhepChinhSua(boolean duocPhepChinhSua) {
        this.duocPhepChinhSua = duocPhepChinhSua;
    }

}
