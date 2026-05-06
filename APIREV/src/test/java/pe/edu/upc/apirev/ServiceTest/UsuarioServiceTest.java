package pe.edu.upc.apirev.ServiceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.upc.apirev.entities.User;
import pe.edu.upc.apirev.servicesinterfaces.IUserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioServiceTest {
    @Autowired
    private IUserService usuarioService;

    @Test
    void testInsertUsuario() {

        User u = new User();

        u.setUserName("Juan");
        u.setUserLastName("Perez");
        u.setUserIdentityDocument(String.valueOf(10000000 + new Random().nextInt(90000000)));
        u.setUserEmail("juan" + System.nanoTime() + "@test.com");
        u.setUserPassword("123456");
        u.setUserRegistrationDate(LocalDate.now());
        u.setEnabled(true);
        u.setRoles(new ArrayList<>());

        User resultado = usuarioService.insert(u);

        assertNotNull(resultado);
        assertNotNull(resultado.getIdUser());
    }
}
