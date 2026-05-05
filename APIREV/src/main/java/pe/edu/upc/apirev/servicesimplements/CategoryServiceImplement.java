package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Category;
import pe.edu.upc.apirev.repositories.ICategoryRepository;
import pe.edu.upc.apirev.servicesinterfaces.ICategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplement implements ICategoryService {
    @Autowired
    public ICategoryRepository cR;
    @Override
    public List<Category> list() {return cR.findAll();}

    @Override
    public Optional<Category> ListId(int id) {
        return cR.findById(id);
    }

    @Override
    public Category insert(Category category) {
        return cR.save(category);
    }

    @Override
    public void Delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void Update(Category c) {
        cR.save(c);
    }
}
