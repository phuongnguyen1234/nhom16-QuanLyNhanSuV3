package com.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "BANGCHAMCONG")
public class BangChamCong {
    @Id
    @Column(name = "MaBangChamCong")
    private String MaBangChamCong;

    @Column(name = "MaNhanSu")
    private String MaNhanSu;

    @Column(name = "ThoiGian")
    private LocalDate ThoiGian;

    @Column(name = "SoNgayLamTrongThang")
    private int SoNgayLamTrongThang;

    @Column(name = "SoNgayNghiCoPhep")
    private int SoNgayNghiCoPhep;

    @Column(name = "SoNgayNghiKhongPhep")
    private int SoNgayNghiKhongPhep;

    @Column(name = "GhiChu")
    private String GhiChu;

    @Column(name = "DuocPhepChinhSua")
    private boolean DuocPhepChinhSua;

    @ManyToOne
    @JoinColumn(name = "MaNhanSu", referencedColumnName = "MaNhanSu", insertable = false, updatable = false)
    private NhanSu NhanSu;

    @OneToOne(mappedBy = "bangChamCong")
    private BangLuong bangLuong;

    public BangChamCong() {
    }

    public BangChamCong(String maBangChamCong, String MaNhanSu, LocalDate ThoiGian, int SoNgayLamTrongThang, int SoNgayNghiCoPhep, int SoNgayNghiKhongPhep, String GhiChu, boolean DuocPhepChinhSua) {
        this.MaBangChamCong = maBangChamCong;
        this.MaNhanSu = MaNhanSu;
        this.ThoiGian = ThoiGian;
        this.SoNgayLamTrongThang = SoNgayLamTrongThang;
        this.SoNgayNghiCoPhep = SoNgayNghiCoPhep;
        this.SoNgayNghiKhongPhep = SoNgayNghiKhongPhep;
        this.GhiChu = GhiChu;
        this.DuocPhepChinhSua = DuocPhepChinhSua;
    }

    // Getters và Setters
    public String getMaBangChamCong() {
        return MaBangChamCong;
    }

    public void setMaBangChamCong(String MaBangChamCong) {
        this.MaBangChamCong = MaBangChamCong;
    }

    public String getMaNhanSu() {
        return MaNhanSu;
    }

    public void setMaNhanSu(String MaNhanSu) {
        this.MaNhanSu = MaNhanSu;
    }

    public LocalDate getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(LocalDate ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public int getSoNgayLamTrongThang() {
        return SoNgayLamTrongThang;
    }

    public void setSoNgayLamTrongThang(int SoNgayLamTrongThang) {
        this.SoNgayLamTrongThang = SoNgayLamTrongThang;
    }

    public int getSoNgayNghiCoPhep() {
        return SoNgayNghiCoPhep;
    }

    public void setSoNgayNghiCoPhep(int SoNgayNghiCoPhep) {
        this.SoNgayNghiCoPhep = SoNgayNghiCoPhep;
    }

    public int getSoNgayNghiKhongPhep() {
        return SoNgayNghiKhongPhep;
    }

    public void setSoNgayNghiKhongPhep(int SoNgayNghiKhongPhep) {
        this.SoNgayNghiKhongPhep = SoNgayNghiKhongPhep;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public boolean isDuocPhepChinhSua() {
        return DuocPhepChinhSua;
    }

    public void setDuocPhepChinhSua(boolean DuocPhepChinhSua) {
        this.DuocPhepChinhSua = DuocPhepChinhSua;
    }

    public NhanSu getNhanSu(){
        return NhanSu;
    }
}