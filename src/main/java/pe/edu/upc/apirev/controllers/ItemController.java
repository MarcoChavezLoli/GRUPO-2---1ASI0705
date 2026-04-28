package pe.edu.upc.apirev.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.ItemDTO;
import pe.edu.upc.apirev.dtos.ItemGeneralDTO;
import pe.edu.upc.apirev.entities.Category;
import pe.edu.upc.apirev.entities.Item;
import pe.edu.upc.apirev.servicesinterfaces.ICategoryService;
import pe.edu.upc.apirev.servicesinterfaces.IItemService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Articulo")
public class ItemController {

    @Autowired
    private IItemService iS;
    private ICategoryService cS;

    @GetMapping
    public ResponseEntity<?> Listar(){
        ModelMapper m = new ModelMapper();
        List<ItemDTO> ListaArticulos = iS.listar().stream().map(y->m.map(y, ItemDTO.class))
                .collect(Collectors.toList());

        if (ListaArticulos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lista está vacía");
        }else {
            return ResponseEntity.ok(ListaArticulos);
        }
    }


    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody ItemDTO dto){
        ModelMapper m=new ModelMapper();
        Optional<Category> category = cS.ListId(dto.getIdCategory());
        if (category.isPresent()) {
            Item item=m.map(dto, Item.class);
            Item cur=iS.insert(item);
            ItemDTO responseDTO=m.map(cur,ItemDTO.class);
            return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al registrar el articulo\nCategoria no encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Item> item = iS.ListId(id);

        if (item.isPresent()) {
            iS.Delete(id);
            return ResponseEntity.ok("Articulo eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Articulo no encontrado");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody ItemGeneralDTO dto) { //cuando actualizamos necesitamos el RB para enviar el valor en el body
        Optional<Item> existente = iS.ListId(dto.getItemId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Articulo no encontrado");
        }

        Item i = existente.get();
        i.setItemCondition(dto.getItemCondition());
        i.setItemDescription(dto.getItemDescription());
        i.setItemName(dto.getItemName());

        iS.Update(i);

        return ResponseEntity.ok("Articulo actualizado correctamente");

        
    }
}
