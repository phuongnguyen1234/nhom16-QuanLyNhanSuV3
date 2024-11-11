package Model;

public class BangLuong {
    private String maBangLuong;
    private String maNhanSu;
    private String maBangChamCong;
    private double luongThucNhan;

    public BangLuong(){}

    public BangLuong(String maBangLuong, String maNhanSu, String maBangChamCong, double luongThucNhan) {
        this.maBangLuong = maBangLuong;
        this.maNhanSu = maNhanSu;
        this.maBangChamCong = maBangChamCong;
        this.luongThucNhan = luongThucNhan;
    }

    // Getter methods for all properties
    public String getMaBangLuong() {
        return maBangLuong;
    }

    public String getMaNhanSu() {
        return maNhanSu;
    }

    public String getMaBangChamCong() {
        return maBangChamCong;
    }

    public double getLuongThucNhan() {
        return luongThucNhan;
    }
}