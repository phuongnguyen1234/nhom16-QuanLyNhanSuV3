package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.NhanSu;

public interface NhanSuRepo extends JpaRepository<NhanSu, String> {
    NhanSu findByMaNhanSu(String maNhanSu);
}