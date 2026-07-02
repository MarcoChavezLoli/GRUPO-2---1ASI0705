package pe.edu.upc.apirev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.DonationDTO;
import pe.edu.upc.apirev.entities.Donation;
import pe.edu.upc.apirev.entities.Item;
import pe.edu.upc.apirev.entities.User;
import pe.edu.upc.apirev.servicesinterfaces.IDonationService;
import pe.edu.upc.apirev.servicesinterfaces.IItemService;
import pe.edu.upc.apirev.servicesinterfaces.IUserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Donacion")
@CrossOrigin(origins = "http://localhost:4200")
public class DonationController {

    @Autowired
    private IDonationService Ds;

    @Autowired
    private IUserService uS;

    @Autowired
    private IItemService iS;

    private DonationDTO convertirADTO(Donation d) {
        DonationDTO dto = new DonationDTO();
        dto.setDonationId(d.getIdDonation());
        dto.setNameDonation(d.getNameDonation());

        if (d.getIdUser() != null) {
            dto.setIdUser(d.getIdUser().getIdUser());
        }

        if (d.getItemId() != null) {
            dto.setItemId(d.getItemId().getItemId());
        }

        return dto;
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> Registrar(@RequestBody DonationDTO ddto) {

        Optional<User> user = uS.listId(ddto.getIdUser());
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al registrar la donación\nUsuario no encontrado");
        }

        Optional<Item> item = iS.ListId(ddto.getItemId());
        if (item.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al registrar la donación\nArtículo no encontrado");
        }

        Donation d = new Donation();
        d.setNameDonation(ddto.getNameDonation());
        d.setIdUser(user.get());
        d.setItemId(item.get());

        Donation guardado = Ds.insert(d);

        return ResponseEntity.status(HttpStatus.CREATED).body(convertirADTO(guardado));
    }

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<DonationDTO> lista = Ds.list()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existen donaciones registradas");
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        Optional<Donation> donation = Ds.listid(id);

        if (donation.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Donación no encontrada");
        }

        return ResponseEntity.ok(convertirADTO(donation.get()));
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Donation> donation = Ds.listid(id);

        if (donation.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Donación no encontrada");
        }

        try {
            Ds.delete(id);
            return ResponseEntity.ok("Donación eliminada correctamente");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No se puede eliminar la donación porque está relacionada con otros registros.");
        }
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody DonationDTO ddto) {

        Optional<Donation> existente = Ds.listid(ddto.getDonationId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Donación no encontrada");
        }

        Donation d = existente.get();
        d.setNameDonation(ddto.getNameDonation());

        Ds.update(d);

        return ResponseEntity.ok("Donación actualizada correctamente");
    }
}