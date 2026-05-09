package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.DonationDetail;
import pe.edu.upc.apirev.repositories.IDonationDetailRepository;
import pe.edu.upc.apirev.servicesinterfaces.IDonationDetailService;

import java.util.List;
import java.util.Optional;
@Service

public class DonationDetailServiceImplement implements IDonationDetailService {


    @Autowired
    private IDonationDetailRepository Ddr;


    @Override
    public DonationDetail insert(DonationDetail dd) {
        return Ddr.save(dd);
    }

    @Override
    public List<DonationDetail> list() {
        return Ddr.findAll();
    }

    @Override
    public void update(DonationDetail dd) {
        Ddr.save(dd);
    }

    @Override
    public void delete(int id) {
        Ddr.deleteById(id);
    }

    @Override
    public Optional<DonationDetail> listid(int id) {
        return Ddr.findById(id);
    }
}
