package ec.gob.metrodequito.controlacceso.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pruebas")
public class PruebaController {
    @GetMapping("/hola")
    public String hola(){
        return "Hola Mundo";
    }
}
