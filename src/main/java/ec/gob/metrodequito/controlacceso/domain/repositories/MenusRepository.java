package ec.gob.metrodequito.controlacceso.domain.repositories;

import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Menus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenusRepository extends JpaRepository<Menus, Integer> {
    @Query("SELECT m FROM Menus m JOIN m.roles r WHERE r.roleId = :roleId ORDER BY r.sortOrder ASC")
    List<Menus> getByRoleId(@Param("roleId") Integer roleId);
}
