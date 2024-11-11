package Service;

@Service
public class PhongBanService {

    @Autowired
    private PhongBanRepo phongBanRepo;

    public List<PhongBan> layTatCaPhongBan() {
        return phongBanRepo.findAll();
    }
}
