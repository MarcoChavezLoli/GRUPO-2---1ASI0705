package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Material;
import pe.edu.upc.apirev.repositories.IMaterialRepository;
import pe.edu.upc.apirev.servicesinterfaces.IMaterialService;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImplement implements IMaterialService {

    @Autowired
    private IMaterialRepository mR;

    @Override
    public List<Material> list() {
        return mR.findAll();
    }

    @Override
    public Material insert(Material material) { return mR.save(material); }

    @Override
    public Optional<Material> ListId(int id) {  return mR.findById(id); }

    @Override
    public void Delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public void Update(Material m) { mR.save(m); }

    }




