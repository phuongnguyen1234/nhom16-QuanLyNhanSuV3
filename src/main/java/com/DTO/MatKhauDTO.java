package com.DTO;

public class MatKhauDTO {
    private String matKhauCu; // Mật khẩu cũ
    private String matKhauMoi; // Mật khẩu mới
    private String matKhauMoiLai; // Nhập lại mật khẩu mới

    // Getters và Setters
    public String getMatKhauCu() {
        return matKhauCu;
    }

    public void setMatKhauCu(String matKhauCu) {
        this.matKhauCu = matKhauCu;
    }

    public String getMatKhauMoi() {
        return matKhauMoi;
    }

    public void setMatKhauMoi(String matKhauMoi) {
        this.matKhauMoi = matKhauMoi;
    }

    public String getMatKhauMoiLai() {
        return matKhauMoiLai;
    }

    public void setMatKhauMoiLai(String matKhauMoiLai) {
        this.matKhauMoiLai = matKhauMoiLai;
    }
}

