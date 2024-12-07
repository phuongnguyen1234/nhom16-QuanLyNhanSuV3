package com.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PHONGBAN")
public class PhongBan {
    @Id
    @Column(name = "MaPhongBan")
    private String maPhongBan;

    @Column(name = "TenPhongBan")
    private String tenPhongBan;

    @OneToMany(mappedBy = "phongBan")
    private List<ChucVu> listChucVu = new ArrayList<>();

    @OneToMany(mappedBy = "phongBan")
    private List<ViTri> listViTri = new ArrayList<>();

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