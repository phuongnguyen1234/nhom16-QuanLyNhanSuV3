package com.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "CHUCVU")
public class ChucVu {
    @EmbeddedId
    private ChucVuId chucVuId;  // Sử dụng @EmbeddedId cho khóa chính phức hợp

    @Column(name = "TenChucVu")
    private String TenChucVu;

    @ManyToOne
    @JoinColumn(name = "MaPhongBan", insertable = false, updatable = false) // Khóa ngoại từ PhongBan
    private PhongBan phongBan;

    @OneToMany(mappedBy = "MaChucVu")
    private List<ViTri> listViTri;


    public ChucVuId getChucVuId() {
        return chucVuId;
    }

    public void setChucVuId(ChucVuId chucVuId) {
        this.chucVuId = chucVuId;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }
}
