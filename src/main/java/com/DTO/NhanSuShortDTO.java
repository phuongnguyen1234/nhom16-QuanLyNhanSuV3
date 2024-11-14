package com.DTO;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder({ "maNhanSu", "tenNhanSu", "tenPhongBan", "tenChucVu", "tenViTri" })

public class NhanSuShortDTO {
	private String MaNhanSu;
    private String TenNhanSu;
	private String TenPhongBan;
    private String TenChucVu; 
    private String TenViTri;

    // Constructor
    public NhanSuShortDTO() {
    }

    public NhanSuShortDTO(String MaNhanSu, String TenNhanSu, String TenPhongBan, String TenChucVu, String TenViTri){
        this.MaNhanSu = MaNhanSu;
        this.TenNhanSu = TenNhanSu;
        this.TenPhongBan = TenPhongBan;
        this.TenChucVu = TenChucVu;
        this.TenViTri = TenViTri;
    }

    // Update all the setters and getters
    public String getMaNhanSu() {
        return MaNhanSu;
    }
    
    public void setMaNhanSu(String MaNhanSu) {
        this.MaNhanSu = MaNhanSu;
    }
    
    public String getTenNhanSu() {
        return TenNhanSu;
    }
    
    public void setTenNhanSu(String TenNhanSu) {
        this.TenNhanSu = TenNhanSu;
    }
    
    public String getTenPhongBan() {
        return TenPhongBan;
    }
    
    public void setTenPhongBan(String TenPhongBan) {
        this.TenPhongBan = TenPhongBan;
    }
    
    public String getTenChucVu() {
        return TenChucVu;
    }
    
    public void setTenChucVu(String TenChucVu) {
        this.TenChucVu = TenChucVu;
    }
    
    public String getTenViTri() {
        return TenViTri;
    }
    
    public void setTenViTri(String TenViTri) {
        this.TenViTri = TenViTri;
    }
}
