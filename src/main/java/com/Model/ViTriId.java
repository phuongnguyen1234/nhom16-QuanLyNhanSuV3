package com.Model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ViTriId implements Serializable {
    private String maViTri; // Mã vị trí
    private String maPhongBan; // Mã phòng ban
    private String maChucVu; // Mã chức vụ

    // Constructor
    public ViTriId() {
    }

    public ViTriId(String MaViTri, String MaPhongBan, String MaChucVu) {
        this.maViTri = MaViTri;
        this.maPhongBan = MaPhongBan;
        this.maChucVu = MaChucVu;
    }

    // Getters và Setters
    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String MaViTri) {
        this.maViTri = MaViTri;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String MaPhongBan) {
        this.maPhongBan = MaPhongBan;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.maChucVu = MaChucVu;
    }

    // equals() và hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ViTriId)) return false;
        ViTriId viTriId = (ViTriId) o;
        return Objects.equals(maViTri, viTriId.maViTri) &&
               Objects.equals(maPhongBan, viTriId.maPhongBan) &&
               Objects.equals(maChucVu, viTriId.maChucVu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maViTri, maPhongBan, maChucVu);
    }
}
