package com.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "NHANSU")
public class NhanSu {
	@Id
    @Column(name = "MaNhanSu")
    private String MaNhanSu;

    @Column(name = "TenNhanSu")
    private String TenNhanSu;

    @Column(name = "GioiTinh")
    private String GioiTinh;

    @Column(name = "NgaySinh")
    private LocalDate NgaySinh;

    @Column(name = "DiaChi")
    private String DiaChi;

    @Column(name = "SoDienThoai")
    private String SoDienThoai;

    @Column(name = "Email")
    private String Email;

    @Column(name = "MaPhongBan")
    private String MaPhongBan;

    @Column(name = "MaChucVu")
    private String MaChucVu;

    @Column(name = "MaViTri")
    private String MaViTri;

    @Column(name = "MucLuong")
    private int MucLuong;

    @Column(name = "MatKhau")
    private String MatKhau;

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

	public NhanSu(String MaNhanSu, String TenNhanSu, String GioiTinh, LocalDate NgaySinh, String DiaChi, String SoDienThoai, String Email, String MaPhongBan, String MaChucVu, String MaViTri, int MucLuong, String MatKhau) {
        this.MaNhanSu = MaNhanSu;
        this.TenNhanSu = TenNhanSu;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;  // sửa lại tên tham số từ 'Email' thành 'email'
        this.MaPhongBan = MaPhongBan;
        this.MaChucVu = MaChucVu;
        this.MaViTri = MaViTri;
        this.MucLuong = MucLuong;
        this.MatKhau = MatKhau;
    }

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
		
    public String getGioiTinh() {
        return GioiTinh;
    }
    
    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
    public LocalDate getNgaySinh() {
        return NgaySinh;
    }
    
    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    
    public String getDiaChi() {
        return DiaChi;
    }
    
    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    public String getSoDienThoai() {
        return SoDienThoai;
    }
    
    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

	public String getEmail() {
	    return Email;
	}
	
	public void setEmail(String Email) {
	    this.Email = Email;
	}
		
	public String getMaPhongBan() {
	    return MaPhongBan;
	}
	
	public void setMaPhongBan(String MaPhongBan) {
	    this.MaPhongBan = MaPhongBan;
	}
		
	public String getMaChucVu() {
	    return MaChucVu;
	}
	
	public void setMaChucVu(String MaChucVu) {
	    this.MaChucVu = MaChucVu;
	}
		
	public String getMaViTri() {
	    return MaViTri;
	}
	
	public void setMaViTri(String MaViTri) {
	    this.MaViTri = MaViTri;
	}
		
	public int getMucLuong() {
	    return MucLuong;
	}
	
	public void setMucLuong(int MucLuong) {
	    this.MucLuong = MucLuong;
	}
		
	public String getMatKhau() {
	    return MatKhau;
	}
	
	public void setMatKhau(String MatKhau) {
	    this.MatKhau = MatKhau;
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