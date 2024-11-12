package com.DTO;

import java.time.LocalDate;

public class NhanSuDTO {
	private String MaNhanSu;
    private String TenNhanSu;
	private String GioiTinh;
    private LocalDate NgaySinh;
    private String DiaChi;
    private String SoDienThoai;
	private String Email;
	private String TenPhongBan;
    private String TenChucVu; 
    private String TenViTri;
	private int MucLuong;
	private String MatKhau;

    // Constructor
    public NhanSuDTO() {
    }

    public NhanSuDTO(String MaNhanSu, String TenNhanSu, String GioiTinh, LocalDate NgaySinh,
    String DiaChi, String SoDienThoai, String Email, String TenPhongBan, String TenChucVu,
    String TenViTri, int MucLuong, String MatKhau) {
        this.MaNhanSu = MaNhanSu;
        this.TenNhanSu = TenNhanSu;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.TenPhongBan = TenPhongBan;
        this.TenChucVu = TenChucVu;
        this.TenChucVu = TenViTri;
        this.MucLuong = MucLuong;
        this.MatKhau = MatKhau;
    }

    // Update all the setters and getters
    public String getMaNhanSu() {
        return MaNhanSu;
    }
    
    public void setMaNhanSu(String MaNhanSu) {
        this.MaNhanSu = MaNhanSu;
    }
    
    public String getTenNhanSu() {
        return TenNhanSu;
    }
    
    public void setTenNhanSu(String TenNhanSu) {
        this.TenNhanSu = TenNhanSu;
    }
    
    public String getGioiTinh() {
        return GioiTinh;
    }
    
    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
    public LocalDate getNgaySinh() {
        return NgaySinh;
    }
    
    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    
    public String getDiaChi() {
        return DiaChi;
    }
    
    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    public String getSoDienThoai() {
        return SoDienThoai;
    }
    
    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }
    
    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public String getTenPhongBan() {
        return TenPhongBan;
    }
    
    public void setTenPhongBan(String TenPhongBan) {
        this.TenPhongBan = TenPhongBan;
    }
    
    public String getTenChucVu() {
        return TenChucVu;
    }
    
    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }
    
    public String getTenViTri() {
        return TenViTri;
    }
    
    public void setTenViTri(String TenViTri) {
        this.TenViTri = TenViTri;
    }
    
    public int getMucLuong() {
        return MucLuong;
    }
    
    public void setMucLuong(int MucLuong) {
        this.MucLuong = MucLuong;
    }
    
    public String getMatKhau() {
        return MatKhau;
    }
    
    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }
}
