package Service;

@Service
public class ViTriService {

    @Autowired
    private ViTriRepo viTriRepo;

    public List<ViTri> layViTriTheoChucVu(String maPhongBan, String maChucVu) {
        return viTriRepo.findByMaPhongBanAndMaChucVu(maPhongBan, maChucVu);
    }
}
