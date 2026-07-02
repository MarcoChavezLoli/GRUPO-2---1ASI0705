package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    public List<Category> list ();
    public Optional<Category> ListId(int id);
    public Category insert(Category category);
    public void Delete(int id);
    public void Update(Category c);

}
