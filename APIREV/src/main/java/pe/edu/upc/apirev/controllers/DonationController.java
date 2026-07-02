package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.CategoryDTO;
import pe.edu.upc.apirev.dtos.DonationDTO;
import pe.edu.upc.apirev.entities.Donation;
import pe.edu.upc.apirev.servicesinterfaces.IDonationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Donacion")
public class DonationController {
    @Autowired
    private IDonationService Ds;

    @PostMapping("/Registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<DonationDTO> Registrar(@RequestBody DonationDTO ddto){
        ModelMapper m =new ModelMapper();
        Donation d=m.map(ddto,Donation.class);
        Donation dt= Ds.insert(d);
        DonationDTO Ddto=m.map(dt,DonationDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(Ddto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Donation> donate = Ds.listid(id);

        if (donate.isPresent()) {
            CategoryDTO dto = m.map(donate.get(), CategoryDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Donacion no encontrada");
        }
    }

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<DonationDTO>>listar(){
        ModelMapper m = new ModelMapper();
        List<DonationDTO>listardonacion = Ds.list()
                .stream().map(y->m.map(y,DonationDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listardonacion);
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Donation> task = Ds.listid(id);

        if (task.isPresent()) {
            Ds.delete(id);
            return ResponseEntity.ok("Donacion eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Donacion no encontrada");
        }
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody DonationDTO ddto) {

        Optional<Donation> existente = Ds.listid(ddto.getIdDonation());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Donacion no encontrada");
        }
        if (ddto.getIdUser() == 0 || ddto.getItemId() == 0) {
            return ResponseEntity.badRequest()
                    .body("Debe de estar dirigido a un usuario");
        }

        Donation d = existente.get();
        d.setNameDonation(ddto.getNameDonation());
        Ds.update(d);

        return ResponseEntity.ok("Donacion actualizada correctamente");
    }

}
