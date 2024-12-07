package com.DTO;

public class NhanSuDTO {
    private String MaNhanSu;
    private String TenNhanSu;
    private String GioiTinh;
    private String NgaySinh;
    private String DiaChi;
    private String SoDienThoai;
    private String Email;
    private String MaPhongBan;
    private String TenPhongBan;
    private String MaChucVu;
    private String TenChucVu;
    private String MaViTri;
    private String TenViTri;
    private int MucLuong;
    private String MatKhau;

    public NhanSuDTO() {}

    // Constructor với tất cả tham số
    public NhanSuDTO(String MaNhanSu, String TenNhanSu, String GioiTinh, String NgaySinh, String DiaChi,
                         String SoDienThoai, String Email, String MaPhongBan, String TenPhongBan, String MaChucVu, 
                         String TenChucVu, String MaViTri, String TenViTri, int MucLuong, String MatKhau) {
        this.MaNhanSu = MaNhanSu;
        this.TenNhanSu = TenNhanSu;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.MaPhongBan = MaPhongBan;
        this.TenPhongBan = TenPhongBan;
        this.MaChucVu = MaChucVu;
        this.TenChucVu = TenChucVu;
        this.MaViTri = MaViTri;
        this.TenViTri = TenViTri;
        this.MucLuong = MucLuong;
        this.MatKhau = MatKhau;
    }

    // Getter và Setter

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

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
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

    public String getMaPhongBan() {
        return MaPhongBan;
    }
    
    public void setMaPhongBan(String MaPhongBan) {
        this.MaPhongBan = MaPhongBan;
    }
    
    public String getMaChucVu() {
        return MaChucVu;
    }
    
    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }
    
    public String getMaViTri() {
        return MaViTri;
    }
    
    public void setMaViTri(String MaViTri) {
        this.MaViTri = MaViTri;
    }
}
