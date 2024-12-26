package com.Model;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "BANGCHAMCONG")
public class BangChamCong {
    @Id
    @Column(name = "MaBangChamCong")
    private String maBangChamCong;

    @Column(name = "MaNhanSu")
    private String maNhanSu;

    @Column(name = "ThoiGian")
    private LocalDate thoiGian;

    @Column(name = "SoNgayLamTrongThang")
    private int soNgayLamTrongThang;

    @Column(name = "SoNgayNghiCoPhep")
    private int soNgayNghiCoPhep;

    @Column(name = "SoNgayNghiKhongPhep")
    private int soNgayNghiKhongPhep;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "DuocPhepChinhSua")
    private boolean duocPhepChinhSua;

    @Column(name = "SoGioLamThem")  // Thêm cột SoGioLamThem
    private int soGioLamThem;  // Thêm thuộc tính soGioLamThem

    // Các mối quan hệ
    @ManyToOne
    @JoinColumn(name = "MaNhanSu", referencedColumnName = "MaNhanSu", insertable = false, updatable = false)
    private NhanSu nhanSu;

    @OneToOne(mappedBy = "bangChamCong")
    private BangLuong bangLuong;

    // Constructors, Getters, Setters
    public BangChamCong() {}

    public BangChamCong(String maBangChamCong, String maNhanSu, LocalDate thoiGian,
                        int soNgayLamTrongThang, int soNgayNghiCoPhep, int soNgayNghiKhongPhep,
                        String ghiChu, boolean duocPhepChinhSua, int soGioLamThem) {
        this.maBangChamCong = maBangChamCong;
        this.maNhanSu = maNhanSu;
        this.thoiGian = thoiGian;
        this.soNgayLamTrongThang = soNgayLamTrongThang;
        this.soNgayNghiCoPhep = soNgayNghiCoPhep;
        this.soNgayNghiKhongPhep = soNgayNghiKhongPhep;
        this.ghiChu = ghiChu;
        this.duocPhepChinhSua = duocPhepChinhSua;
        this.soGioLamThem = soGioLamThem; // Set giá trị soGioLamThem
    }

    public int getSoGioLamThem() {
        return soGioLamThem;
    }

    public void setSoGioLamThem(int soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }

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

    public NhanSu getNhanSu() {
        return nhanSu;
    }

    public void setNhanSu(NhanSu nhanSu) {
        this.nhanSu = nhanSu;
    }

    public BangLuong getBangLuong() {
        return bangLuong;
    }

    public void setBangLuong(BangLuong bangLuong) {
        this.bangLuong = bangLuong;
    }
}


