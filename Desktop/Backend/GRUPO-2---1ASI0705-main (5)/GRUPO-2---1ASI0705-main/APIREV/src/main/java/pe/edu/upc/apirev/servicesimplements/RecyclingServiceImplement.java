package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Recycling;
import pe.edu.upc.apirev.repositories.IRecyclingRepository;
import pe.edu.upc.apirev.servicesinterfaces.IRecyclingService;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingServiceImplement implements IRecyclingService {
    @Autowired
    public IRecyclingRepository rR;

    @Override
    public List<Recycling> list() {
        return rR.findAll();
    }

    @Override
    public Recycling insert(Recycling r) {
        return rR.save(r);
    }

    @Override
    public Optional<Recycling> ListId(int id) {
        return rR.findById(id);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);

    }

    @Override
    public void Update(Recycling r) {
        rR.save(r);
    }

    @Override
    public List<Object[]> quantityRecyclingNative() {
        return rR.quantityRecyclingByUser();
    }
}
