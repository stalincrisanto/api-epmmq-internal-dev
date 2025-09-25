package ec.gob.metrodequito.controlacceso.infrastructure.controllers;

import ec.gob.metrodequito.controlacceso.domain.services.UserRolService;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.UserRol;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class UserRolController {
    private final UserRolService service;

    @GetMapping("/user/{id}")
    private ResponseEntity<List<UserRol>>getRolesByUserId(@PathVariable("id") String id) {
        Optional<List<UserRol>> userRoles = service.findByUserId(id);
        return new ResponseEntity<>(userRoles.get(), userRoles.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
