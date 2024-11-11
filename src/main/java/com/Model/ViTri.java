package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@IdClass(ViTriId.class) // Sử dụng lớp ID cho khóa chính
public class ViTri {
    @Id
    private String maViTri; // Mã vị trí (khóa chính)

    @Id
    private String maPhongBan; // Mã phòng ban (khóa ngoại)

    @Id
    private String maChucVu; // Mã chức vụ (khóa ngoại)

    private String tenViTri; // Tên vị trí

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ma_chuc_vu", referencedColumnName = "maChucVu", insertable = false, updatable = false),
        @JoinColumn(name = "ma_phong_ban", referencedColumnName = "maPhongBan", insertable = false, updatable = false)
    })
    private ChucVu chucVu;

    @ManyToOne
    @JoinColumn(name = "ma_phong_ban", insertable = false, updatable = false)
    private PhongBan phongBan;

    @OneToMany(mappedBy = "viTri")
    private List<NhanSu> ListNhanSu;

    public String getMaViTri() {
        return MaViTri;
    }

    public void setMaViTri(String MaViTri) {
        this.MaViTri = MaViTri;
    }

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

    public String getMaPhongBan() {
        return MaPhongBan;
    }

    public void setMaPhongBan(String MaPhongBan) {
        this.MaPhongBan = MaPhongBan;
    }

    public String getTenViTri() {
        return TenViTri;
    }

    public void setTenViTri(String TenViTri) {
        this.TenViTri = TenViTri;
    }
}
