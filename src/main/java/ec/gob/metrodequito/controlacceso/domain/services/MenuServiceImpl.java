package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.domain.services.dto.MenuDto;
import ec.gob.metrodequito.controlacceso.domain.services.dto.MenusCortoDto;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Menus;
import ec.gob.metrodequito.controlacceso.domain.repositories.MenusRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements  MenuService {
    private final MenusRepository repository;

    public List<Menus> getAll() {
        return repository.findAll();
    }

    @Override
    public Menus save(Menus menu) {
        return repository.save(menu);
    }

    @Override
    public void delete(Menus menu) {
        repository.delete(menu);
    }

    @Override
    public Optional<Menus> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<MenuDto> getByRole(Integer roleId) {
        List<Menus> allMenus = repository.getByRoleId(roleId);

        // Convert entities to DTOs
        List<MenuDto> menuDtos = allMenus.stream().map(this::convertToDto).collect(Collectors.toList());

        // Build hierarchy
        return menuDtos.stream()
                .filter(menu -> menu.getParentId() == null)
                .peek(menu -> menu.setSubmenus(findSubmenus(menu, menuDtos)))
                .collect(Collectors.toList());
    }

    @Override
    public List<MenusCortoDto> getByIdRole(Integer roleId) {
        List<Menus> allMenus = repository.getByRoleId(roleId);

        List<MenusCortoDto> menuDtos = allMenus.stream().map(menus -> {
            MenusCortoDto dto = new MenusCortoDto();
            dto.setTitle(menus.getName());
            dto.setPath(menus.getPath());
            dto.setParentId(menus.getParentId());
            dto.setId(menus.getId());
            return dto;
        }).collect(Collectors.toList());

        return menuDtos.stream()
                .filter(menu -> menu.getParentId() == null)
                .peek(menu -> menu.setSubNav(findSubNav(menu, menuDtos)))
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuDto> getHierarchicalMenu() {
        List<Menus> allMenus = repository.findAll();

        // Convert entities to DTOs
        List<MenuDto> menuDtos = allMenus.stream().map(this::convertToDto).collect(Collectors.toList());

        // Build hierarchy
        return menuDtos.stream()
                .filter(menu -> menu.getParentId() == null)
                .peek(menu -> menu.setSubmenus(findSubmenus(menu, menuDtos)))
                .collect(Collectors.toList());
    }

    private List<MenusCortoDto> findSubNav(MenusCortoDto parent, List<MenusCortoDto> allMenus) {
        return allMenus.stream()
                .filter(menu -> parent.getId().equals(menu.getParentId()))
                .peek(menu -> menu.setSubNav(findSubNav(menu, allMenus)))
                .collect(Collectors.toList());
    }

    private List<MenuDto> findSubmenus(MenuDto parent, List<MenuDto> allMenus) {
        return allMenus.stream()
                .filter(menu -> parent.getId().equals(menu.getParentId()))
                .peek(menu -> menu.setSubmenus(findSubmenus(menu, allMenus)))
                .collect(Collectors.toList());
    }

    private MenuDto convertToDto(Menus menu) {
        MenuDto dto = new MenuDto();
        dto.setId(menu.getId());
        dto.setName(menu.getName());
        dto.setPath(menu.getPath());
        dto.setParentId(menu.getParentId());
        dto.setIcon(menu.getIcon());
        dto.setIsActive(menu.getIsActive());
        return dto;
    }
}
