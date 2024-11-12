package com.Model;

import java.io.Serializable;
import java.util.Objects;

public class ChucVuId implements Serializable {
    private String maChucVu;
    private String maPhongBan;

    public ChucVuId() {
    }

    public ChucVuId(String maChucVu, String maPhongBan) {
        this.maChucVu = maChucVu;
        this.maPhongBan = maPhongBan;
    }

    // Getters và Setters
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

    // equals() và hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChucVuId)) return false;
        ChucVuId chucVuId = (ChucVuId) o;
        return Objects.equals(maChucVu, chucVuId.maChucVu) &&
               Objects.equals(maPhongBan, chucVuId.maPhongBan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maChucVu, maPhongBan);
    }
}
