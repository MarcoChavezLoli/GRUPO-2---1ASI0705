package pe.edu.upc.apirev.servicesinterfaces;


import pe.edu.upc.apirev.entities.Material;

import java.util.List;
import java.util.Optional;

public interface IMaterialService {

    public List<Material> list ();
    public Material insert(Material m);
    public Optional<Material> ListId(int id);
    public void Delete(int id);
    public void Update(Material m);
    
    List<Object[]> searchByTypeNative(String type);
}
