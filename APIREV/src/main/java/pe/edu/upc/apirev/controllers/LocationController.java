package pe.edu.upc.apirev.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.LocationDTO;
import pe.edu.upc.apirev.dtos.LocationGeneralDTO;
import pe.edu.upc.apirev.entities.Location;
import pe.edu.upc.apirev.servicesinterfaces.ILocationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    private ILocationService lS;

    @GetMapping("/listar/ubicaciones")
    public ResponseEntity<List<LocationDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<LocationDTO> lista = lS.list().stream()
                .map(y -> m.map(y, LocationDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
    @PostMapping("/registar/ubicaciones")
    public ResponseEntity<LocationGeneralDTO> registrar(@RequestBody LocationGeneralDTO dto){
        ModelMapper m=new ModelMapper();
        Location c=m.map(dto, Location.class);
        Location cur= lS.insert(c);
        LocationGeneralDTO responseDTO=m.map(cur,LocationGeneralDTO.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/ubicaciones/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody LocationGeneralDTO dto) {
        Optional<Location> existente = lS.listId(dto.getIdLocation());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ubicacion no encontrado");
        }
        Location l = existente.get();
        l.setDistrictLocation(dto.getDistrictLocation());
        l.setAddressLocation( dto.getAddressLocation());
        l.setLatitudeLocation(dto.getLatitudeLocation());
        l.setLongitudeLocation(dto.getLongitudeLocation());
        lS.update(l);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ubicacion Actualizado Correctamente");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Location> location = lS.listId(id);

        if (location.isPresent()) {
            lS.delete(id);
            return ResponseEntity.ok("Ubicacion eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ubicacion no encontrado");
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Location> location = lS.listId(id);

        if (location.isPresent()) {
            LocationGeneralDTO dto = m.map(location.get(), LocationGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ubicacion no encontrada");
        }
    }
}
