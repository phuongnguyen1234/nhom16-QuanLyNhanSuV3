package com.Model;

import java.io.Serializable;
import java.util.Objects;

public class ChucVuId implements Serializable {
    private String maChucVu;
    private String maPhongBan;

    public ChucVuId() {
    }

    public ChucVuId(String MaChucVu, String MaPhongBan) {
        this.maChucVu = MaChucVu;
        this.maPhongBan = MaPhongBan;
    }

    // Getters và Setters
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
