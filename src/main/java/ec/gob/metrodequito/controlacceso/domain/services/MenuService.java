package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.domain.services.dto.MenuDto;
import ec.gob.metrodequito.controlacceso.domain.services.dto.MenusCortoDto;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Menus;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    List<Menus> getAll();
    Menus save(Menus menu);
    void delete(Menus menu);
    Optional<Menus> getById(Integer id);
    List<MenuDto> getByRole(Integer roleId);
    public List<MenusCortoDto> getByIdRole(Integer roleId);
    List<MenuDto> getHierarchicalMenu();
}
