
package com.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHUCVU")
@IdClass(ChucVuId.class)
public class ChucVu {
    @Id
    @Column(name = "MaChucVu")
    private String maChucVu;

    @Id
    @Column(name = "MaPhongBan")
    private String maPhongBan;

    @Column(name = "TenChucVu")
    private String tenChucVu;

    @ManyToOne
    @JoinColumn(name = "MaPhongBan", referencedColumnName = "MaPhongBan", insertable = false, updatable = false)
    private PhongBan phongBan;

    @OneToMany(mappedBy = "chucVu")
    private List<ViTri> listViTri = new ArrayList<>();

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String TenChucVu) {
        this.tenChucVu = TenChucVu;
    }

    public String getMaChucVu() {
        return maChucVu;
    }
    
    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }
    
    public String getMaPhongBan() {
        return maPhongBan;
    }
    
    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

}
