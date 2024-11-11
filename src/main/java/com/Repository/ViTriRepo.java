package Repository;

@Repository
public interface ViTriRepo extends JpaRepository<ViTri, String> {
    List<ViTri> findByMaPhongBanAndMaChucVu(String maPhongBan, String maChucVu);
}
