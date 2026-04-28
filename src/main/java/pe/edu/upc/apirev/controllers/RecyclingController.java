package pe.edu.upc.apirev.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.apirev.servicesinterfaces.IRecyclingService;

@RestController
@RequestMapping("/api/Reciclaje")
public class RecyclingController {

    @Autowired
    private IRecyclingService rS;


}
