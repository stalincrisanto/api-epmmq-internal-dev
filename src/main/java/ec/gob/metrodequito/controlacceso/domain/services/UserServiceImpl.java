package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.domain.repositories.UsersRepository;
import ec.gob.metrodequito.controlacceso.domain.services.dto.UsersDto;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository repository;
    @Override
    public Optional<UsersDto> getOne(String Id) {
        Optional<Users> usuario = repository.findById(Id);
        UsersDto userDto;// = new UsersDto();
          if(usuario.isPresent()){
              userDto = UsersDto.builder()
                        .id(usuario.get().getId())
                        .username(usuario.get().getUsername())
                        .isActive(usuario.get().getIsActive())
                        .isLooked(usuario.get().getIsLooked())
                        .lastLoginAt(usuario.get().getLastLoginAt())
                        .failedLoginAttemps(usuario.get().getFailedLoginAttemps())
                        .passwordUpdatedAt(usuario.get().getPasswordUpdatedAt())
                        .build();
              return Optional.of(userDto);
            }
            else {
              return Optional.empty();
            }
    }

    @Override
    public Optional<Users> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Users> getByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Users save(Users user) {
        return repository.save(user);
    }

    @Override
    public void delete(Users user) {
        repository.delete(user);
    }
}
