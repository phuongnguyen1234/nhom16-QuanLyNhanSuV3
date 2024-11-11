package Repository;

@Repository
public interface ChucVuRepo extends JpaRepository<ChucVu, String> {
    List<ChucVu> findByMaPhongBan(String maPhongBan);
}
