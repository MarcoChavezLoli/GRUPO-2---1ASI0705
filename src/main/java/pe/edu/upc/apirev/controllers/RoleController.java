package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.apirev.dtos.LocationDTO;
import pe.edu.upc.apirev.dtos.RoleDTO;
import pe.edu.upc.apirev.servicesinterfaces.ILocationService;
import pe.edu.upc.apirev.servicesinterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
public class RoleController {

    @Autowired
    private IRoleService rS;

    @GetMapping("/roles")
    public ResponseEntity<List<RoleDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<RoleDTO> lista = rS.list().stream()
                .map(y -> m.map(y, RoleDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }
}
