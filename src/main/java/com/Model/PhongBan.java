package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class PhongBan {
    @Id
    private String maPhongBan;

    private String tenPhongBan;

    @OneToMany(mappedBy = "phongBan")
    private List<ChucVu> listChucVu;

    @OneToMany(mappedBy = "phongBan")
    private List<ViTri> listViTri;

    public String getMaPhongBan(){
        return MaPhongBan;
    }

    public String getTenPhongBan(){
        return TenPhongBan;
    }

    public void setMaPhongBan(String MaPhongBan){
        this.MaPhongBan = MaPhongBan;
    }

    public void setTenPhongBan(String TenPhongBan){
        this.TenPhongBan = TenPhongBan;
    }
}
