package ec.gob.metrodequito.controlacceso.domain.repositories;

import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {
}
