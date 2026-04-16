package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Category;
import pe.edu.upc.apirev.repositories.ICategoryRepository;
import pe.edu.upc.apirev.servicesinterfaces.ICategoryService;

import java.util.List;

@Service
public class CategoryServiceImplement implements ICategoryService {
    @Autowired
    public ICategoryRepository cR;
    @Override
    public List<Category> list() {return cR.findAll();}
}
