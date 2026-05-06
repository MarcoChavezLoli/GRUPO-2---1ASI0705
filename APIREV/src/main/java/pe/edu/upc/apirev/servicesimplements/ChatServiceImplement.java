package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Chat;
import pe.edu.upc.apirev.repositories.IChatRepository;
import pe.edu.upc.apirev.servicesinterfaces.IChatService;

import java.util.List;

@Service
public class ChatServiceImplement implements IChatService {

    @Autowired
    private IChatRepository Cr;


    @Override
    public Chat insert(Chat c) {
        return Cr.save(c);
    }

    @Override
    public List<Chat> list() {
        return Cr.findAll();
    }

    @Override
    public void update(Chat c) {
        Cr.save(c);
    }

    @Override
    public void delete(int id) {
        Cr.deleteById(id);
    }
}
