package DTO;

import java.time.LocalDate;

public class NhanSuDTO {
	private String maNhanSu;
    private String tenNhanSu;
	private String gioiTinh;
    private LocalDate ngaySinh;
    private String diaChi;
    private String soDT;
	private String email;
	private String tenPhongBan;
    private String tenChucVu; 
    private String tenViTri;
	private int mucLuong;
	private String matKhau;

    // Constructor
    public NhanSuDTO() {
    }

    public NhanSuDTO(String maNhanSu, String tenNhanSu, String gioiTinh, LocalDate ngaySinh, String diaChi, String soDT, String email, String tenPhongBan, String tenChucVu, String tenViTri, int mucLuong, String matKhau) {
        this.maNhanSu = maNhanSu;
        this.tenNhanSu = tenNhanSu;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.email = email;
        this.tenPhongBan = tenPhongBan;
        this.tenChucVu = tenChucVu;
        this.tenViTri = tenViTri;
        this.mucLuong = mucLuong;
        this.matKhau = matKhau;
    }

    // Getters và Setters
    public String getMaNhanSu() {
        return maNhanSu;
    }

    public void setMaNhanSu(String maNhanSu) {
        this.maNhanSu = maNhanSu;
    }

    public String getTenNhanSu() {
        return tenNhanSu;
    }

    public void setTenNhanSu(String tenNhanSu) {
        this.tenNhanSu = tenNhanSu;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

	public String getGioiTinh() {
		return gioiTinh;
	}
	
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String getSoDT() {
		return soDT;
	}
	
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getMucLuong() {
		return mucLuong;
	}
	
	public void setMucLuong(int mucLuong) {
		this.mucLuong = mucLuong;
	}
	
	public String getMatKhau() {
		return matKhau;
	}
	
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
}
