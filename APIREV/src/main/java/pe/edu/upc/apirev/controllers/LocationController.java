package pe.edu.upc.apirev.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.apirev.dtos.LocationDTO;
import pe.edu.upc.apirev.entities.Location;
import pe.edu.upc.apirev.servicesinterfaces.ILocationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LocationController {
    @Autowired
    private ILocationService lS;

    @GetMapping("/ubicaciones")
    public ResponseEntity<List<LocationDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<LocationDTO> lista = lS.list().stream()
                .map(y -> m.map(y, LocationDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }
}
