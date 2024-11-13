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

    @OneToOne
    @JoinColumn(name = "MaBangChamCong", referencedColumnName = "MaBangChamCong")
    private BangChamCong bangChamCong;
}