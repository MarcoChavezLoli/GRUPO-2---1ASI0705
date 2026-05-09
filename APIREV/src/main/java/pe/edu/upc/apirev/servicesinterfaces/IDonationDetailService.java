package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.DonationDetail;

import java.util.List;
import java.util.Optional;

public interface IDonationDetailService {

    public DonationDetail insert(DonationDetail dd);
    public List<DonationDetail> list();
    public void update(DonationDetail dd);
    public void delete (int id);
    public Optional<DonationDetail> listid(int id);

}
