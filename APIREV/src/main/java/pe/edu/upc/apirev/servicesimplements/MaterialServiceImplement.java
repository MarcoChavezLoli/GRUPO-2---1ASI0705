package pe.edu.upc.apirev.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Material;
import pe.edu.upc.apirev.repositories.IMaterialRepository;
import pe.edu.upc.apirev.servicesinterfaces.IMaterialService;

import java.util.List;

@Service
public class MaterialServiceImplement implements IMaterialService {

    @Autowired
    private IMaterialRepository mR;

    @Override
    public void insert(Material material) {
        mR.save(material);
    }

    @Override
    public List<Material> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int idMaterial) {
        mR.deleteById(idMaterial);
    }

    @Override
    public Material listId(int idMaterial) {
        return mR.findById(idMaterial).orElse(new Material());
    }

    @Override
    public void update(Material material) {
        mR.save(material);
    }
}
=======
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.servicesinterfaces.IMaterialService;

@Service
public class MaterialServiceImplement implements IMaterialService {

}