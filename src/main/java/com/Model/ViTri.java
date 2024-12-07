package com.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "VITRI")
@IdClass(ViTriId.class) 
public class ViTri {
    @Id
    @Column(name = "MaViTri")
    private String maViTri; 

    @Id
    @Column(name = "MaPhongBan")
    private String maPhongBan; 

    @Id
    @Column(name = "MaChucVu")
    private String maChucVu; 

    @Column(name = "TenViTri")
    private String tenViTri;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "MaChucVu", referencedColumnName = "MaChucVu", insertable = false, updatable = false),
        @JoinColumn(name = "MaPhongBan", referencedColumnName = "MaPhongBan", insertable = false, updatable = false)
    })
    private ChucVu chucVu;

    @ManyToOne
    @JoinColumn(name = "MaPhongBan", insertable = false, updatable = false)
    private PhongBan phongBan;

    @OneToMany(mappedBy = "viTri")
    private List<NhanSu> ListNhanSu = new ArrayList<>();

    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String MaViTri) {
        this.maViTri = MaViTri;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.maChucVu = MaChucVu;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String MaPhongBan) {
        this.maPhongBan = MaPhongBan;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String TenViTri) {
        this.tenViTri = TenViTri;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }
}