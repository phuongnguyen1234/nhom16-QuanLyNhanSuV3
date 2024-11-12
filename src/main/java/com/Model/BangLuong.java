package com.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "BANGLUONG")
public class BangLuong {
    @Id
    @Column(name = "MaBangLuong")
    private String MaChucVuaBangLuong;

    @Column(name = "TongThuNhap")
    private int TongThuNhap;

    @Column(name = "LuongThucNhan")
    private int LuongThucNhan;

    @Column(name = "GhiChu")
    private String GhiChu;

    @OneToOne
    @JoinColumn(name = "MaBangChamCong", referencedColumnName = "MaBangChamCong")
    private BangChamCong bangChamCong;
}