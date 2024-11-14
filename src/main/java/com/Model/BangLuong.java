package com.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "BANGLUONG")
public class BangLuong {

    @Id
    @Column(name = "MaBangLuong")
    private String maChucVuaBangLuong;

    @Column(name = "TongThuNhap")
    private int tongThuNhap;

    @Column(name = "LuongThucNhan")
    private int luongThucNhan;

    @Column(name = "GhiChu")
    private String ghiChu;

    // New properties for month and year
    @Column(name = "Month")
    private int month;

    @Column(name = "Year")
    private int year;

    @OneToOne
    @JoinColumn(name = "MaBangChamCong", referencedColumnName = "MaBangChamCong")
    private BangChamCong bangChamCong;

    // Getters and setters for all properties
    public String getMaChucVuaBangLuong() {
        return maChucVuaBangLuong;
    }

    public void setMaChucVuaBangLuong(String maChucVuaBangLuong) {
        this.maChucVuaBangLuong = maChucVuaBangLuong;
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

    public BangChamCong getBangChamCong() {
        return bangChamCong;
    }

    public void setBangChamCong(BangChamCong bangChamCong) {
        this.bangChamCong = bangChamCong;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
