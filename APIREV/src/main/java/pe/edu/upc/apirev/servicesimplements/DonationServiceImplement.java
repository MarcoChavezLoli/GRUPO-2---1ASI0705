package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Donation;
import pe.edu.upc.apirev.repositories.IDonationRepository;
import pe.edu.upc.apirev.servicesinterfaces.IDonationService;

import java.util.List;
import java.util.Optional;
@Service

public class DonationServiceImplement implements IDonationService {

    @Autowired
    private IDonationRepository Dr;


    @Override
    public Donation insert(Donation d) {
        return Dr.save(d);
    }

    @Override
    public List<Donation> list() {
        return Dr.findAll();
    }

    @Override
    public void update(Donation d) {
        Dr.save(d);
    }

    @Override
    public void delete(int id) {
        Dr.deleteById(id);
    }

    @Override
    public Optional<Donation> listid(int id) {
        return Dr.findById(id);
    }
}
