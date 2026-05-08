package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.ChatDTO;
import pe.edu.upc.apirev.dtos.DonacionDTO;
import pe.edu.upc.apirev.entities.Chat;
import pe.edu.upc.apirev.entities.Donacion;
import pe.edu.upc.apirev.servicesinterfaces.IDonacionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Donacion")
public class DonacionController {

    @Autowired
    private IDonacionService Ds;

    @PostMapping("/Registrar")
    public ResponseEntity<DonacionDTO> Registrar(@RequestBody DonacionDTO ddto){
        ModelMapper m =new ModelMapper();
        Donacion d=m.map(ddto,Donacion.class);
        Donacion dt= Ds.insert(d);
        DonacionDTO Ddto=m.map(dt,DonacionDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(Ddto);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DonacionDTO>>listar(){
        ModelMapper m = new ModelMapper();
        List<DonacionDTO>listardonacion = Ds.list()
                .stream().map(y->m.map(y,DonacionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listardonacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Donacion> task = Ds.listid(id);

        if (task.isPresent()) {
            Ds.delete(id);
            return ResponseEntity.ok("Donnacion eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Donacion no encontrada");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody DonacionDTO ddto) {

        Optional<Donacion> existente = Ds.listid(ddto.getIddonacion());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Donacion no encontrada");
        }
        if (ddto.getIdUser() == null || ddto.getItemId() == null) {
            return ResponseEntity.badRequest()
                    .body("Debe de estar dirigido a un usuario");
        }

        Donacion d = existente.get();

        d.setNamedonacion(ddto.getNamedonacion());

        Ds.update(d);

        return ResponseEntity.ok("Donacion actualizada correctamente");
    }

}

