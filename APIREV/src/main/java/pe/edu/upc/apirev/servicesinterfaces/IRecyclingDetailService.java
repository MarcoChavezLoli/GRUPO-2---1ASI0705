package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.RecyclingDetail;

import java.util.List;
import java.util.Optional;

public interface IRecyclingDetailService {

    public List<RecyclingDetail> list ();
    public RecyclingDetail insert(RecyclingDetail r);
    public Optional<RecyclingDetail> ListId(int id);
    public void Delete(int id);
    public void Update(RecyclingDetail r);


}
