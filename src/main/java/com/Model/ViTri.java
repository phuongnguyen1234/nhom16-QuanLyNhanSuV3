package com.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@IdClass(ViTriId.class) // Sử dụng lớp ID cho khóa chính
public class ViTri {
    @Id
    private String MaViTri; // Mã vị trí (khóa chính)

    @Id
    private String MaPhongBan; // Mã phòng ban (khóa ngoại)

    @Id
    private String MaChucVu; // Mã chức vụ (khóa ngoại)

    private String TenViTri; // Tên vị trí

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
        return MaViTri;
    }

    public void setMaViTri(String MaViTri) {
        this.MaViTri = MaViTri;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

    public String getMaPhongBan() {
        return MaPhongBan;
    }

    public void setMaPhongBan(String MaPhongBan) {
        this.MaPhongBan = MaPhongBan;
    }

    public String getTenViTri() {
        return TenViTri;
    }

    public void setTenViTri(String TenViTri) {
        this.TenViTri = TenViTri;
    }
}
