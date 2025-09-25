package ec.gob.metrodequito.controlacceso.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apipuente")
public class ApiPuenteController {
   public String hola(){
       return "hola";
   }
}
