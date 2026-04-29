package pe.edu.upc.apirev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.CollectionPointDTO;
import pe.edu.upc.apirev.entities.CollectionPoint;
import pe.edu.upc.apirev.servicesinterfaces.ICollectionPointService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/collectionpoints")
public class CollectionPointController {

    @Autowired
    private ICollectionPointService cpS;

    @PostMapping
    public void insert(@RequestBody CollectionPointDTO dto) {
        CollectionPoint cp = new CollectionPoint();
        cp.setCollectionPointName(dto.getCollectionPointName());
        cp.setCollectionPointAddress(dto.getCollectionPointAddress());
        cp.setCollectionPointLatitude(dto.getCollectionPointLatitude());
        cp.setCollectionPointLongitude(dto.getCollectionPointLongitude());
        cpS.insert(cp);
    }

    @GetMapping
    public List<CollectionPointDTO> list() {
        return cpS.list().stream().map(x -> {
            CollectionPointDTO dto = new CollectionPointDTO();
            dto.setIdCollectionPoint(x.getIdCollectionPoint());
            dto.setCollectionPointName(x.getCollectionPointName());
            dto.setCollectionPointAddress(x.getCollectionPointAddress());
            dto.setCollectionPointLatitude(x.getCollectionPointLatitude());
            dto.setCollectionPointLongitude(x.getCollectionPointLongitude());
            return dto;
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        cpS.delete(id);
    }

    @GetMapping("/{id}")
    public CollectionPointDTO listId(@PathVariable("id") int id) {
        CollectionPoint cp = cpS.listId(id);
        CollectionPointDTO dto = new CollectionPointDTO();
        dto.setIdCollectionPoint(cp.getIdCollectionPoint());
        dto.setCollectionPointName(cp.getCollectionPointName());
        dto.setCollectionPointAddress(cp.getCollectionPointAddress());
        dto.setCollectionPointLatitude(cp.getCollectionPointLatitude());
        dto.setCollectionPointLongitude(cp.getCollectionPointLongitude());
        return dto;
    }

    @PutMapping
    public void update(@RequestBody CollectionPointDTO dto) {
        CollectionPoint cp = new CollectionPoint();
        cp.setIdCollectionPoint(dto.getIdCollectionPoint());
        cp.setCollectionPointName(dto.getCollectionPointName());
        cp.setCollectionPointAddress(dto.getCollectionPointAddress());
        cp.setCollectionPointLatitude(dto.getCollectionPointLatitude());
        cp.setCollectionPointLongitude(dto.getCollectionPointLongitude());
        cpS.update(cp);
    }
}