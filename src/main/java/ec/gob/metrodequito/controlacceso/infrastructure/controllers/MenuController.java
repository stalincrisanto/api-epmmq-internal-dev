package ec.gob.metrodequito.controlacceso.infrastructure.controllers;

import ec.gob.metrodequito.controlacceso.domain.services.dto.MenuDto;
import ec.gob.metrodequito.controlacceso.domain.services.dto.MenusCortoDto;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Menus;
import ec.gob.metrodequito.controlacceso.domain.services.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController {
    private final MenuService service;

    @GetMapping("/all")
    public ResponseEntity<List<Menus>> traeTodo(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<MenusCortoDto>> traeMenusXRol(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(service.getByIdRole(id), HttpStatus.OK);
    }

    @GetMapping("/hierarchical")
    public ResponseEntity<List<MenuDto>> getHierarchicalMenu() {
        return new ResponseEntity<>(service.getHierarchicalMenu(), HttpStatus.OK);
    }

}
