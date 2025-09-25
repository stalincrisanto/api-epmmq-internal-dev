package ec.gob.metrodequito.controlacceso.infrastructure.controllers;

import ec.gob.metrodequito.controlacceso.domain.services.UserService;
import ec.gob.metrodequito.controlacceso.domain.services.dto.UsersDto;
import ec.gob.metrodequito.controlacceso.domain.services.exceptions.UsuarioNoEncontradoException;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Users;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsersDto>> getUserById(@PathVariable("id") String id){
        return new ResponseEntity<>(service.getOne(id), service.getOne(id).isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/secure/{id}")
    public ResponseEntity<Optional<Users>> getFullUserById(@PathVariable("id") String id){
        return new ResponseEntity<>(service.getById(id), service.getById(id).isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
