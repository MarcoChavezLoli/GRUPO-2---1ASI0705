package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Donation;

import java.util.List;
import java.util.Optional;

public interface IDonationService {
    public Donation insert(Donation d);
    public List<Donation> list();
    public void update(Donation d);
    public void delete (int id);
    public Optional<Donation> listid(int id);
    List<Object[]>quantityDonationUser();
    List<Object[]>donationCondition();
}
