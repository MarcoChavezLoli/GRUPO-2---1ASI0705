package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.RecyclingDetail;
import pe.edu.upc.apirev.repositories.IRecyclingDetailRepository;
import pe.edu.upc.apirev.servicesinterfaces.IRecyclingDetailService;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingDetailServiceImplement implements IRecyclingDetailService {
    @Autowired
    public IRecyclingDetailRepository rdR;

    @Override
    public List<RecyclingDetail> list() {
        return rdR.findAll();
    }

    @Override
    public RecyclingDetail insert(RecyclingDetail r) {
        return rdR.save(r);
    }

    @Override
    public Optional<RecyclingDetail> ListId(int id) {
        return rdR.findById(id);
    }

    @Override
    public void Delete(int id) {
        rdR.deleteById(id);
    }

    @Override
    public void Update(RecyclingDetail r) {
        rdR.save(r);
    }
}


