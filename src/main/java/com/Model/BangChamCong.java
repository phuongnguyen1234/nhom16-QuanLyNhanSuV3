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

    @ManyToOne
    @JoinColumn(name = "MaNhanSu", referencedColumnName = "MaNhanSu", insertable = false, updatable = false)
    private NhanSu nhanSu;

    @OneToOne(mappedBy = "bangChamCong")
    private BangLuong bangLuong;

    public BangChamCong() {
    }

    public BangChamCong(String maBangChamCong, String MaNhanSu, LocalDate ThoiGian, int SoNgayLamTrongThang, int SoNgayNghiCoPhep, int SoNgayNghiKhongPhep, String GhiChu, boolean DuocPhepChinhSua) {
        this.maBangChamCong = maBangChamCong;
        this.maNhanSu = MaNhanSu;
        this.thoiGian = ThoiGian;
        this.soNgayLamTrongThang = SoNgayLamTrongThang;
        this.soNgayNghiCoPhep = SoNgayNghiCoPhep;
        this.soNgayNghiKhongPhep = SoNgayNghiKhongPhep;
        this.ghiChu = GhiChu;
        this.duocPhepChinhSua = DuocPhepChinhSua;
    }

    // Getters và Setters
    public String getMaBangChamCong() {
        return maBangChamCong;
    }

    public void setMaBangChamCong(String MaBangChamCong) {
        this.maBangChamCong = MaBangChamCong;
    }

    public String getMaNhanSu() {
        return maNhanSu;
    }

    public void setMaNhanSu(String MaNhanSu) {
        this.maNhanSu = MaNhanSu;
    }

    public LocalDate getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDate ThoiGian) {
        this.thoiGian = ThoiGian;
    }

    public int getSoNgayLamTrongThang() {
        return soNgayLamTrongThang;
    }

    public void setSoNgayLamTrongThang(int SoNgayLamTrongThang) {
        this.soNgayLamTrongThang = SoNgayLamTrongThang;
    }

    public int getSoNgayNghiCoPhep() {
        return soNgayNghiCoPhep;
    }

    public void setSoNgayNghiCoPhep(int SoNgayNghiCoPhep) {
        this.soNgayNghiCoPhep = SoNgayNghiCoPhep;
    }

    public int getSoNgayNghiKhongPhep() {
        return soNgayNghiKhongPhep;
    }

    public void setSoNgayNghiKhongPhep(int SoNgayNghiKhongPhep) {
        this.soNgayNghiKhongPhep = SoNgayNghiKhongPhep;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.ghiChu = GhiChu;
    }

    public boolean isDuocPhepChinhSua() {
        return duocPhepChinhSua;
    }

    public void setDuocPhepChinhSua(boolean DuocPhepChinhSua) {
        this.duocPhepChinhSua = DuocPhepChinhSua;
    }

    public NhanSu getNhanSu(){
        return nhanSu;
    }
}