package ec.gob.metrodequito.controlacceso.domain.repositories;

import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.UserRol;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.UserRolPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRolRepository extends JpaRepository<UserRol, UserRolPk> {
    @Query(value = "SELECT ur FROM UserRol ur WHERE ur.userId = :userId")
    Optional<List<UserRol>> findAllByUserId(@Param("userId") String userId);
}
