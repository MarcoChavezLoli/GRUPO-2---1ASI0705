package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Material;
import java.util.List;

public interface IMaterialService {
    public void insert(Material material);
    public List<Material> list();
    public void delete(int idMaterial);
    public Material listId(int idMaterial);
    public void update(Material material);
}
