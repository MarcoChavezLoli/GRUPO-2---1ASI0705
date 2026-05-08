package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.DetalleDonacionDTO;
import pe.edu.upc.apirev.entities.DetalleDonacion;
import pe.edu.upc.apirev.servicesinterfaces.IDetalleDonacionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/DetalleDonacion")
public class DetalleDonacionController {

    @Autowired
    private IDetalleDonacionService Dds;

    @PostMapping("/Registrar")
    public ResponseEntity<DetalleDonacionDTO> Registrar(@RequestBody DetalleDonacionDTO dddto){
        ModelMapper m =new ModelMapper();
        DetalleDonacion Dd=m.map(dddto,DetalleDonacion.class);
        DetalleDonacion Ddt= Dds.insert(Dd);
        DetalleDonacionDTO DdDto=m.map(Ddt,DetalleDonacionDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(DdDto);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DetalleDonacionDTO>>listar(){
        ModelMapper m = new ModelMapper();
        List<DetalleDonacionDTO>listardonaciones = Dds.list()
                .stream().map(y->m.map(y,DetalleDonacionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listardonaciones);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<DetalleDonacion> task = Dds.listid(id);

        if (task.isPresent()) {
            Dds.delete(id);
            return ResponseEntity.ok("Detalle de la Donacion eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Detalle de la Donacion no encontrado");
        }
    }


    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody DetalleDonacionDTO Dddto) {

        Optional<DetalleDonacion> existente = Dds.listid(Dddto.getIddetalledonacion());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Detalle de la Donacion no encontrada");
        }
        if (Dddto.getFecharegistrada() == null || Dddto.getDescripciondetalle() == null) {
            return ResponseEntity.badRequest()
                    .body("Las fechas no pueden ser nulas ni la descripcion de la Donacion");
        }

        DetalleDonacion dd = existente.get();

        dd.setDescripciondetalle(Dddto.getDescripciondetalle());
        dd.setEstadotrazabilidad(Dddto.getEstadotrazabilidad());
        dd.setFecharegistrada(Dddto.getFecharegistrada());

        Dds.update(dd);

        return ResponseEntity.ok("El Detalle de la Donacion fue actualizada correctamente");
    }

}
