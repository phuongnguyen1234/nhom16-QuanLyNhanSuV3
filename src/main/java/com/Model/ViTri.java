package com.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "VITRI")
@IdClass(ViTriId.class) 
public class ViTri {
    @Id
    @Column(name = "MaViTri")
    private String maViTri; 

    @Id
    @Column(name = "PhongBan")
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
    private List<NhanSu> ListNhanSu;

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
}
