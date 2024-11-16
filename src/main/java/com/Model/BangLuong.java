package com.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "BANGLUONG")
public class BangLuong {
    @Id
    @Column(name = "MaBangLuong")
    private String maBangLuong;

    @Column(name = "MaBangChamCong")
    private String maBangChamCong;

    @Column(name = "TongThuNhap")
    private int tongThuNhap;

    @Column(name = "LuongThucNhan")
    private int luongThucNhan;

    @Column(name = "GhiChu")
    private String ghiChu;

    @OneToOne
    @JoinColumn(name = "MaBangChamCong", referencedColumnName = "MaBangChamCong", insertable = false, updatable = false)
    private BangChamCong bangChamCong;

    // Getters and setters for all properties
    public String getMaBangLuong() {
        return maBangLuong;
    }

    public void setMaBangLuong(String maBangLuong) {
        this.maBangLuong = maBangLuong;
    }

    public String getMaBangChamCong(){
        return maBangChamCong;
    }

    public void setMaBangChamCong(String maBangChamCong) {
        this.maBangChamCong = maBangChamCong;
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
}
