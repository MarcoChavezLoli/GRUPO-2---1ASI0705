package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.apirev.dtos.PublicationDTO;
import pe.edu.upc.apirev.servicesinterfaces.IPublicationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/publicacion")
public class PublicationController {
    @Autowired
    private IPublicationService pServ;
    @GetMapping("/publicacion/listar")
    public ResponseEntity<List<PublicationDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<PublicationDTO> lista = pServ.list().stream()
                .map(y -> m.map(y, PublicationDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
}
