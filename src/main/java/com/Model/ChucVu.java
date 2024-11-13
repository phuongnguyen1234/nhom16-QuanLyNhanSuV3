package com.Model;

import jakarta.persistence.*;
import java.util.List;

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
    @JoinColumn(name = "MaPhongBan", insertable = false, updatable = false) 
    private PhongBan phongBan;

    @OneToMany(mappedBy = "chucVu")
    private List<ViTri> listViTri;

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String TenChucVu) {
        this.tenChucVu = TenChucVu;
    }
}
