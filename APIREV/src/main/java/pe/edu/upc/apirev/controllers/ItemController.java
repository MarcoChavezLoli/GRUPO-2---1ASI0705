package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.ItemDTO;
import pe.edu.upc.apirev.dtos.ItemGeneralDTO;
import pe.edu.upc.apirev.dtos.QueryNativeDTO;
import pe.edu.upc.apirev.entities.Category;
import pe.edu.upc.apirev.entities.Item;
import pe.edu.upc.apirev.servicesinterfaces.ICategoryService;
import pe.edu.upc.apirev.servicesinterfaces.IItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Articulo")
public class ItemController {

    @Autowired
    private IItemService iS;

    @Autowired
    private ICategoryService cS;

    @GetMapping("/listar/Articulo")
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
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody ItemGeneralDTO dto) {
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

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Item> project = iS.ListId(id);

        if (project.isPresent()) {
            ItemGeneralDTO dto = m.map(project.get(), ItemGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Articulo no encontrado no encontrado");
        }
    }

    @GetMapping("/cantidad-Articulo-Categoria")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?>obtenerCantidadArticuloCategoria(){
        List<Object[]> listaCantidad=iS.quantityItemNative();
        if(listaCantidad.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay articulos");
        }
        List<QueryNativeDTO> respuesta=new ArrayList<>();
        for(Object[] fila:listaCantidad){
            QueryNativeDTO dto=new QueryNativeDTO();

            dto.setIdCategory(((Number)fila[0]).intValue());
            dto.setNameCategory((String) fila[1]);
            dto.setQuantityItems(((Number)fila[2]).intValue());
            respuesta.add(dto);
        }
        return  ResponseEntity.ok(respuesta);
    }

}