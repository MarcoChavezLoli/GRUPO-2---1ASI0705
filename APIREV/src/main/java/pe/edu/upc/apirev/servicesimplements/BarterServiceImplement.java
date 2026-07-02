package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Barter;
import pe.edu.upc.apirev.repositories.IBarterRepository;
import pe.edu.upc.apirev.servicesinterfaces.IBarterService;

import java.util.List;
import java.util.Optional;

@Service
public class BarterServiceImplement implements IBarterService {
    @Autowired
    private  IBarterRepository bR;

    @Override
    public List<Barter> list() {
        return bR.findAll();
    }

    @Override
    public Barter insert(Barter b) {
        return bR.save(b);
    }

    @Override
    public void update(Barter b) {
        bR.save(b);

    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);

    }

    @Override
    public Optional<Barter> listId(int id) {
        return bR.findById(id) ;
    }

    @Override
    public List<Object[]> findAllBartersWithUsers() {
        return bR.findAllWithUsers();
    }


}
