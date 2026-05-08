package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.ChatDTO;
import pe.edu.upc.apirev.entities.Chat;
import pe.edu.upc.apirev.servicesinterfaces.IChatService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Chat")
public class ChatController {

    @Autowired
    private IChatService Cs;

    @PostMapping("/Registrar")
    public ResponseEntity<ChatDTO> Registrar(@RequestBody ChatDTO cdto){
        ModelMapper m =new ModelMapper();
        Chat c=m.map(cdto,Chat.class);
        Chat ct= Cs.insert(c);
        ChatDTO ChDto=m.map(ct,ChatDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(ChDto);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ChatDTO>>listar(){
        ModelMapper m = new ModelMapper();
        List<ChatDTO>listarTareas = Cs.list()
                .stream().map(y->m.map(y,ChatDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listarTareas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Chat> task = Cs.listid(id);

        if (task.isPresent()) {
            Cs.delete(id);
            return ResponseEntity.ok("Chat eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Chat no encontrado");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody ChatDTO cdto) {

        Optional<Chat> existente = Cs.listid(cdto.getIdchat());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Chat no encontrado");
        }
        if (cdto.getChatfechaenvio() == null || cdto.getChatcontenido() == null) {
            return ResponseEntity.badRequest()
                    .body("Las fechas no pueden ser nulas");
        }

        Chat c = existente.get();

        c.setChatcontenido(cdto.getChatcontenido());
        c.setChatfechaenvio(cdto.getChatfechaenvio());
        c.setChatstatus(cdto.getChatstatus());

        Cs.update(c);

        return ResponseEntity.ok("Chat actualizado correctamente");
    }


}
