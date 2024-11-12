package com.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class PhongBan {
    @Id
    @Column(name = "MaPhongBan")
    private String MaPhongBan;

    @Column(name = "TenPhongBan")
    private String TenPhongBan;

    @OneToMany(mappedBy = "phongBan")
    private List<ChucVu> listChucVu;

    @OneToMany(mappedBy = "phongBan")
    private List<ViTri> listViTri;

    public String getMaPhongBan(){
        return MaPhongBan;
    }

    public String getTenPhongBan(){
        return TenPhongBan;
    }

    public void setMaPhongBan(String MaPhongBan){
        this.MaPhongBan = MaPhongBan;
    }

    public void setTenPhongBan(String TenPhongBan){
        this.TenPhongBan = TenPhongBan;
    }
}
