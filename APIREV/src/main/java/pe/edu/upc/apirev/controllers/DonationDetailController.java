package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.DonationDetailDTO;
import pe.edu.upc.apirev.entities.DonationDetail;
import pe.edu.upc.apirev.servicesinterfaces.IDonationDetailService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/DetalleDonacion")
public class DonationDetailController {
    @Autowired
    private IDonationDetailService Dds;

    @PostMapping("/Registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<DonationDetailDTO> Registrar(@RequestBody DonationDetailDTO dto){
        ModelMapper m =new ModelMapper();
        DonationDetail Dd=m.map(dto,DonationDetail.class);
        DonationDetail Ddt= Dds.insert(Dd);
        DonationDetailDTO DdDto=m.map(Ddt,DonationDetailDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(DdDto);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<DonationDetailDTO>>listar(){
        ModelMapper m = new ModelMapper();
        List<DonationDetailDTO>listardonaciones = Dds.list()
                .stream().map(y->m.map(y,DonationDetailDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listardonaciones);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<DonationDetail> task = Dds.listid(id);

        if (task.isPresent()) {
            Dds.delete(id);
            return ResponseEntity.ok("Detalle de la Donacion eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Detalle de la Donacion no encontrado");
        }
    }


    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody DonationDetailDTO Dddto) {

        Optional<DonationDetail> existente = Dds.listid(Dddto.getIdDonationDetail());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Detalle de la Donacion no encontrada");
        }
        if (Dddto.getDateRegistration() == null || Dddto.getDetailDescription() == null) {
            return ResponseEntity.badRequest()
                    .body("Las fechas no pueden ser nulas ni la descripcion de la Donacion");
        }

        DonationDetail dd = existente.get();

        dd.setDetailDescription(Dddto.getDetailDescription());
        dd.setTraceabilityStatus(Dddto.isTraceabilityStatus());
        dd.setDateRegistration(Dddto.getDateRegistration());

        Dds.update(dd);

        return ResponseEntity.ok("El Detalle de la Donación fue actualizada correctamente");
    }
}
