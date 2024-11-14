package com.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "NHANSU")
public class NhanSu {
	@Id
    @Column(name = "MaNhanSu")
    private String maNhanSu;

    @Column(name = "TenNhanSu")
    private String tenNhanSu;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "Email")
    private String email;

    @Column(name = "MaPhongBan")
    private String maPhongBan;

    @Column(name = "MaChucVu")
    private String maChucVu;

    @Column(name = "MaViTri")
    private String maViTri;

    @Column(name = "MucLuong")
    private int mucLuong;

    @Column(name = "MatKhau")
    private String matKhau;

    // Các quan hệ @ManyToOne
    @ManyToOne
    @JoinColumn(name = "MaPhongBan", referencedColumnName = "MaPhongBan", insertable = false, updatable = false)
    private PhongBan phongBan;

    @ManyToOne
    @JoinColumn(name = "MaChucVu", referencedColumnName = "MaChucVu", insertable = false, updatable = false)
    private ChucVu chucVu;

    @ManyToOne
    @JoinColumn(name = "MaViTri", referencedColumnName = "MaViTri", insertable = false, updatable = false)
    private ViTri viTri;

	public NhanSu(){}

	public NhanSu(String MaNhanSu, String TenNhanSu, String GioiTinh, LocalDate NgaySinh,
    String DiaChi, String SoDienThoai, String Email, String MaPhongBan, String MaChucVu,
    String MaViTri, int MucLuong, String MatKhau) {
        this.maNhanSu = MaNhanSu;
        this.tenNhanSu = TenNhanSu;
        this.gioiTinh = GioiTinh;
        this.ngaySinh = NgaySinh;
        this.diaChi = DiaChi;
        this.soDienThoai = SoDienThoai;
        this.email = Email;
        this.maPhongBan = MaPhongBan;
        this.maChucVu = MaChucVu;
        this.maViTri = MaViTri;
        this.mucLuong = MucLuong;
        this.matKhau = MatKhau;
    }

	public String getMaNhanSu() {
	    return maNhanSu;
	}
	
	public void setMaNhanSu(String MaNhanSu) {
	    this.maNhanSu = MaNhanSu;
	}
	
	public String getTenNhanSu() {
	    return tenNhanSu;
	}
	
	public void setTenNhanSu(String TenNhanSu) {
	    this.tenNhanSu = TenNhanSu;
	}
		
    public String getGioiTinh() {
        return gioiTinh;
    }
    
    public void setGioiTinh(String GioiTinh) {
        this.gioiTinh = GioiTinh;
    }
    
    public LocalDate getNgaySinh() {
        return ngaySinh;
    }
    
    public void setNgaySinh(LocalDate NgaySinh) {
        this.ngaySinh = NgaySinh;
    }
    
    public String getDiaChi() {
        return diaChi;
    }
    
    public void setDiaChi(String DiaChi) {
        this.diaChi = DiaChi;
    }
    
    public String getSoDienThoai() {
        return soDienThoai;
    }
    
    public void setSoDienThoai(String SoDienThoai) {
        this.soDienThoai = SoDienThoai;
    }

	public String getEmail() {
	    return email;
	}
	
	public void setEmail(String Email) {
	    this.email = Email;
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
		
	public String getMaViTri() {
	    return maViTri;
	}
	
	public void setMaViTri(String MaViTri) {
	    this.maViTri = MaViTri;
	}
		
	public int getMucLuong() {
	    return mucLuong;
	}
	
	public void setMucLuong(int MucLuong) {
	    this.mucLuong = MucLuong;
	}
		
	public String getMatKhau() {
	    return matKhau;
	}
	
	public void setMatKhau(String MatKhau) {
	    this.matKhau = MatKhau;
	}

	// Phương thức trả về đối tượng PhongBan liên kết
    public PhongBan getPhongBan() {
        return phongBan;
    }

    // Phương thức trả về đối tượng ChucVu liên kết
    public ChucVu getChucVu() {
        return chucVu;
    }

    // Phương thức trả về đối tượng ViTri liên kết
    public ViTri getViTri() {
        return viTri;
    }

	
}