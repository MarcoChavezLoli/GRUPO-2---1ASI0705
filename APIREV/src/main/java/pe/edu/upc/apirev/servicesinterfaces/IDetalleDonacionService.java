package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Chat;
import pe.edu.upc.apirev.entities.DetalleDonacion;

import java.util.List;
import java.util.Optional;

public interface IDetalleDonacionService {

    public DetalleDonacion insert(DetalleDonacion dd);
    public List<DetalleDonacion> list();
    public void update(DetalleDonacion dd);
    public void delete (int id);
    public Optional<DetalleDonacion>listid(int id);

}
