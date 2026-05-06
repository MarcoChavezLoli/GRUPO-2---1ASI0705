package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Chat;
import pe.edu.upc.apirev.entities.DetalleDonacion;

import java.util.List;

public interface IDetalleDonacionService {

    public DetalleDonacion insert(DetalleDonacion dd);
    public List<DetalleDonacion> list();
    public void update(DetalleDonacion dd);
    public void delete (int id);

}
