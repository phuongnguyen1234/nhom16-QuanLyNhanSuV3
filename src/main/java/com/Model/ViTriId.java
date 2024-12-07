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

    public ViTriId(String maViTri, String maPhongBan, String maChucVu) {
        this.maViTri = maViTri;
        this.maPhongBan = maPhongBan;
        this.maChucVu = maChucVu;
    }

    // Getters và Setters
    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
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