package com.DTO;

import java.time.LocalDate;

public class BangLuongDTO {
    private String maBangLuong;
    private String maBangChamCong;
    private String tenNhanSu;
    private String tenPhongBan;
    private String tenChucVu;
    private String tenViTri;
    private LocalDate thoiGian;
    private int soNgayLamTrongThang;
    private int soNgayNghiCoPhep;
    private int soNgayNghiKhongPhep;
    private int tongThuNhap;
    private int luongThucNhan;
    private String ghiChu;

    public BangLuongDTO(String maBangLuong, String maBangChamCong, String tenNhanSu, String tenPhongBan, String tenChucVu,
    String tenViTri, LocalDate thoiGian, int soNgayLamTrongThang, int soNgayNghiCoPhep, int soNgayNghiKhongPhep, int tongThuNhap,
    int luongThucNhan, String ghiChu) {
        this.maBangLuong = maBangLuong;
        this.maBangChamCong = maBangChamCong;
        this.tenNhanSu = tenNhanSu;
        this.tenPhongBan = tenPhongBan;
        this.tenChucVu = tenChucVu;
        this.tenViTri = tenViTri;
        this.thoiGian = thoiGian;
        this.soNgayLamTrongThang = soNgayLamTrongThang;
        this.soNgayNghiCoPhep = soNgayNghiCoPhep;
        this.soNgayNghiKhongPhep = soNgayNghiKhongPhep;
        this.tongThuNhap = tongThuNhap;
        this.luongThucNhan = luongThucNhan;
        this.ghiChu = ghiChu;
    }
    
    public String getMaBangLuong() {
        return maBangLuong;
    }
    
    public void setMaBangLuong(String maBangLuong) {
        this.maBangLuong = maBangLuong;
    }
    
    public String getMaBangChamCong() {
        return maBangChamCong;
    }
    
    public void setMaBangChamCong(String maBangChamCong) {
        this.maBangChamCong = maBangChamCong;
    }
    
    public String getTenNhanSu() {
        return tenNhanSu;
    }
    
    public void setTenNhanSu(String tenNhanSu) {
        this.tenNhanSu = tenNhanSu;
    }
    
    public String getTenPhongBan() {
        return tenPhongBan;
    }
    
    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }
    
    public String getTenChucVu() {
        return tenChucVu;
    }
    
    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }
    
    public String getTenViTri() {
        return tenViTri;
    }
    
    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
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
    
    public int getTongThuNhap() {
        return tongThuNhap;
    }
    
    public void setTongThuNhap(int tongThuNhap) {
        this.tongThuNhap = tongThuNhap;
    }
    
    public int getLuongThucNhan() {
        return luongThucNhan;
    }
    
    public void setLuongThucNhan(int luongThucNhan) {
        this.luongThucNhan = luongThucNhan;
    }
    
    public String getGhiChu() {
        return ghiChu;
    }
    
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
