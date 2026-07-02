package pe.edu.upc.apirev.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('RECOLECTOR')")
    public ResponseEntity<?> listar() {
        ModelMapper m = new ModelMapper();
        List <Location> loctationsExistentes = lS.list();
        if(loctationsExistentes.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existen Ubicaciones");
        }
        List<LocationGeneralDTO> lista = loctationsExistentes.stream()
                .map(y -> m.map(y, LocationGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
    @PostMapping("/registrar/ubicaciones")
    @PreAuthorize("hasAnyAuthority('RECOLECTOR')")
    public ResponseEntity<?> registrar(@RequestBody LocationGeneralDTO dto) {

        if (dto.getAddressLocation() == null || dto.getAddressLocation().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La dirección de la ubicación no puede estar vacía.");
        }

        if (dto.getDistrictLocation() == null || dto.getDistrictLocation().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El nombre del distrito no puede estar vacío.");
        }
        if (dto.getLatitudeLocation() == null || dto.getLongitudeLocation() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Las coordenadas (latitud y longitud) son obligatorias.");
        }
        ModelMapper m = new ModelMapper();
        Location c = m.map(dto, Location.class);
        lS.insert(c);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ubicación creada exitosamente ");
    }

    @PutMapping("/ubicaciones/actualiza")
    @PreAuthorize("hasAnyAuthority('RECOLECTOR')")
    public ResponseEntity<String> actualizar(@RequestBody LocationGeneralDTO dto) {
        Optional<Location> existente = lS.listId(dto.getIdLocation());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ubicacion no encontrado");
        }
        if (dto.getAddressLocation() == null || dto.getAddressLocation().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La dirección de la ubicación no puede estar vacía.");
        }

        if (dto.getDistrictLocation() == null || dto.getDistrictLocation().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El nombre del distrito no puede estar vacío.");
        }
        if (dto.getLatitudeLocation() == null || dto.getLongitudeLocation() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Las coordenadas (latitud y longitud) son obligatorias.");
        }
        Location l = existente.get();
        l.setDistrictLocation(dto.getDistrictLocation());
        l.setAddressLocation( dto.getAddressLocation());
        l.setLatitudeLocation(dto.getLatitudeLocation());
        l.setLongitudeLocation(dto.getLongitudeLocation());
        lS.update(l);
        return ResponseEntity.status(HttpStatus.OK).body("Ubicacion Actualizado Correctamente");
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('RECOLECTOR')")
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
    @PreAuthorize("hasAnyAuthority('RECOLECTOR')")
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
