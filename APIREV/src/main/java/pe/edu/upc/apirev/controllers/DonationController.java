package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.DonationConditionDTO;
import pe.edu.upc.apirev.dtos.DonationDTO;
import pe.edu.upc.apirev.dtos.QuantityDonationUserDTO;
import pe.edu.upc.apirev.entities.Donation;
import pe.edu.upc.apirev.entities.Item;
import pe.edu.upc.apirev.entities.User;
import pe.edu.upc.apirev.servicesinterfaces.IDonationService;
import pe.edu.upc.apirev.servicesinterfaces.IItemService;
import pe.edu.upc.apirev.servicesinterfaces.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Donacion")
public class DonationController {
    @Autowired
    private IDonationService Ds;
    @Autowired
    private IUserService iuS;
    @Autowired
    private IItemService itS;


    @PostMapping("/Registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> registrar(@RequestBody DonationDTO ddto) {

        ModelMapper m = new ModelMapper();

        Optional<Item> item = itS.ListId(ddto.getItemId());
        Optional<User> user = iuS.listId(ddto.getIdUser());

        if (item.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item no encontrado");
        }

        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }

        Donation d = m.map(ddto, Donation.class);

        // Asignar las relaciones
        d.setItemId(item.get());
        d.setIdUser(user.get());

        Donation dt = Ds.insert(d);

        DonationDTO respuesta = new DonationDTO();
        respuesta.setIdDonation(dt.getIdDonation());
        respuesta.setNameDonation(dt.getNameDonation());
        respuesta.setItemId(dt.getItemId().getItemId());
        respuesta.setIdUser(dt.getIdUser().getIdUser());

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }



    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {

        ModelMapper m = new ModelMapper();

        List<Donation> lista = Ds.list();

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La lista está vacía");
        }

        List<DonationDTO> respuesta = new ArrayList<>();

        for (Donation d : lista) {

            DonationDTO dto = new DonationDTO();

            // ModelMapper solo para los atributos simples
            dto.setIdDonation(m.map(d.getIdDonation(), Integer.class));
            dto.setNameDonation(m.map(d.getNameDonation(), String.class));

            // Relaciones manualmente
            dto.setItemId(d.getItemId().getItemId());
            dto.setIdUser(d.getIdUser().getIdUser());

            respuesta.add(dto);
        }

        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> eliminar(@PathVariable int id) {

        Optional<Donation> donation = Ds.listid(id);
        if (donation.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Donación no encontrada");
        }
        Ds.delete(id);

        return ResponseEntity.ok("Donación eliminada correctamente");
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> actualizar(@RequestBody DonationDTO ddto) {

        Optional<Donation> donation = Ds.listid(ddto.getIdDonation());

        if (donation.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Donación no encontrada");
        }

        Optional<Item> item = itS.ListId(ddto.getItemId());

        if (item.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Item no encontrado");
        }

        Optional<User> user = iuS.listId(ddto.getIdUser());

        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }

        Donation d = donation.get();

        d.setNameDonation(ddto.getNameDonation());
        d.setItemId(item.get());
        d.setIdUser(user.get());

        Ds.update(d);

        return ResponseEntity.ok("Donación actualizada correctamente");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable int id) {

        Optional<Donation> donation = Ds.listid(id);

        if (donation.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Donación no encontrada");
        }

        ModelMapper m = new ModelMapper();

        Donation d = donation.get();

        DonationDTO dto = new DonationDTO();

        dto.setIdDonation(m.map(d.getIdDonation(), Integer.class));
        dto.setNameDonation(m.map(d.getNameDonation(), String.class));
        dto.setItemId(d.getItemId().getItemId());
        dto.setIdUser(d.getIdUser().getIdUser());

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/cantidad-donaciones-usuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> obtenerCantidadDonacionesUsuario() {

        List<Object[]> lista = Ds.quantityDonationUser();

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay registros");
        }

        List<QuantityDonationUserDTO> respuesta = new ArrayList<>();

        for (Object[] fila : lista) {

            QuantityDonationUserDTO dto = new QuantityDonationUserDTO();

            dto.setUser((String) fila[0]);
            dto.setQuantityDonation(((Number) fila[1]).intValue());

            respuesta.add(dto);
        }

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/cantidad-donaciones-condicion")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> obtenerCantidadDonacionesCondicion() {

        List<Object[]> lista = Ds.donationCondition();

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay registros");
        }

        List<DonationConditionDTO> respuesta = new ArrayList<>();

        for (Object[] fila : lista) {

            DonationConditionDTO dto = new DonationConditionDTO();
            dto.setCondition((String) fila[0]);
            dto.setQuantity(((Number) fila[1]).intValue());
            respuesta.add(dto);
        }

        return ResponseEntity.ok(respuesta);
    }

}
