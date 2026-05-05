package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Product;
import pe.edu.upc.apirev.repositories.IProductRepository;
import pe.edu.upc.apirev.servicesinterfaces.IProductService;

import java.util.List;

@Service
public class ProductServiceImplement implements IProductService {
    @Autowired
    private IProductRepository pRe;

    @Override
    public List<Product> list() {
        return pRe.findAll();
    }
}
