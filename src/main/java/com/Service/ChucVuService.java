package Service;

@Service
public class ChucVuService {

    @Autowired
    private ChucVuRepo chucVuRepo;

    public List<ChucVu> layChucVuTheoPhongBan(String maPhongBan) {
        return chucVuRepo.findByMaPhongBan(maPhongBan);
    }
}
