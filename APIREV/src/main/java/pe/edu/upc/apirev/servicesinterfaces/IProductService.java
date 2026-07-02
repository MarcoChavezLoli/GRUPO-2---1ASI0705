package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> list();
    public Product insert (Product p);
    public void update(Product p);
    public Optional<Product> listId(int id);
    public void delete(int id);
    List<Object[]> countProductsByCategory();


}
