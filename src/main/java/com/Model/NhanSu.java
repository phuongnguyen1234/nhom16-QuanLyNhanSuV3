package Model;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.lang.annotation.Inherited;
import java.time.LocalDate;

@Entity
public class NhanSu {
	@Id
    private String MaNhanSu;

	private String TenNhanSu;
    private String GioiTinh;
    private LocalDate NgaySinh;
    private String DiaChi;
    private String SoDT;
	private String Email;
	private String MaPhongBan;
	private String MaChucVu;
	private String MaViTri;
	private int MucLuong;
	private String MatKhau;

	public NhanSu(){}

	public NhanSu(String MaNhanSu, String TenNhanSu, String GioiTinh, LocalDate NgaySinh, String DiaChi, String SoDT, String Email, String MaPhongBan, String MaChucVu, String MaViTri, int MucLuong, String MatKhau) {
	    this.MaNhanSu = MaNhanSu;
	    this.TenNhanSu = TenNhanSu;
	    this.GioiTinh = GioiTinh;
	    this.NgaySinh = NgaySinh;
	    this.DiaChi = DiaChi;
	    this.SoDT = SoDT;
	    this.Email = Email;
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
    
    public String getSoDT() {
        return SoDT;
    }
    
    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
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

	
}