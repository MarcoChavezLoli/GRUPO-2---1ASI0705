package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Product;
import pe.edu.upc.apirev.repositories.IProductRepository;
import pe.edu.upc.apirev.servicesinterfaces.IProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplement implements IProductService {

    @Autowired
    private IProductRepository pRe;

    @Override
    public List<Product> list() {
        return pRe.findAll();
    }

    @Override
    public Product insert(Product p) {
        return pRe.save(p);
    }

    @Override
    public void update(Product p) {
        pRe.save(p);
    }

    @Override
    public Optional<Product> listId(int id) {
        return pRe.findById(id);
    }

    @Override
    public void delete(int id) {
        pRe.deleteById(id);

    }

    @Override
    public List<Object[]> countProductsByCategory() {
        return pRe.countProductsByCategory();
    }


}
