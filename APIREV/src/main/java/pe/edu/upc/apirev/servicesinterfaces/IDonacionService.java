package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Chat;
import pe.edu.upc.apirev.entities.Donacion;

import java.util.List;

public interface IDonacionService {

    public Donacion insert(Donacion d);
    public List<Donacion> list();
    public void update(Donacion d);
    public void delete (int id);

}
