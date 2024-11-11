package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@IdClass(ChucVuID.class)
public class ChucVu {
    @Id
    private String maChucVu;

    @Id
    private String maPhongBan;

    private String tenChucVu;

    @ManyToOne
    @JoinColumn(name = "ma_phong_ban", insertable = false, updatable = false) // Khóa ngoại từ PhongBan
    private PhongBan phongBan;

    @OneToMany(mappedBy = "chucVu")
    private List<ViTri> listViTri;

    public String getMaChucVu() {
        return MaChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        MaChucVu = maChucVu;
    }

    public String getMaPhongBan() {
        return MaPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        MaPhongBan = maPhongBan;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        TenChucVu = tenChucVu;
    }
}
