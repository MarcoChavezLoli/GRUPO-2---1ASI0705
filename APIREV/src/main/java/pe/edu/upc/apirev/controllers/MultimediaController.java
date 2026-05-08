package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.apirev.dtos.MultimediaDTO;
import pe.edu.upc.apirev.entities.Multimedia;
import pe.edu.upc.apirev.servicesinterfaces.IMultimediaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/multimedia")
public class MultimediaController {
    @Autowired
    private IMultimediaService mService;

    @GetMapping("/listar")
    public ResponseEntity<List<MultimediaDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<MultimediaDTO> lista = mService.list().stream()
                .map(y -> m.map(y, MultimediaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    public ResponseEntity<MultimediaDTO> registrar (@RequestBody MultimediaDTO dto){
        ModelMapper m = new ModelMapper();

        Multimedia c = m.map(dto, Multimedia.class);
        Multimedia cur= mService.insert(c);
        MultimediaDTO responseDTO=m.map(cur,MultimediaDTO.class);

        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}
