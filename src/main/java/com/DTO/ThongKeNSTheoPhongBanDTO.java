package com.DTO;

public class ThongKeNSTheoPhongBanDTO {
    private String tenPhongBan;
    private int soLuong;

    public ThongKeNSTheoPhongBanDTO(String tenPhongBan, int soLuong) {
        this.tenPhongBan = tenPhongBan;
        this.soLuong = soLuong;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }
    
    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
