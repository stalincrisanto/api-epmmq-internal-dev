package ec.gob.metrodequito.controlacceso.domain.repositories;

import ec.gob.metrodequito.controlacceso.domain.services.dto.UsersDto;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {
    @Query("SELECT u FROM Users u WHERE u.username = :username")
    Optional<Users> findByUsername(@Param("username") String username);
}
