package com.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class PhongBan {
    @Id
    @Column(name = "MaPhongBan")
    private String maPhongBan;

    @Column(name = "TenPhongBan")
    private String tenPhongBan;

    @OneToMany(mappedBy = "phongBan")
    private List<ChucVu> listChucVu;

    @OneToMany(mappedBy = "phongBan")
    private List<ViTri> listViTri;

    public String getMaPhongBan(){
        return maPhongBan;
    }

    public String getTenPhongBan(){
        return tenPhongBan;
    }

    public void setMaPhongBan(String MaPhongBan){
        this.maPhongBan = MaPhongBan;
    }

    public void setTenPhongBan(String TenPhongBan){
        this.tenPhongBan = TenPhongBan;
    }
}
