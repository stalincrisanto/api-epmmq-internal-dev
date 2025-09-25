package ec.gob.metrodequito.controlacceso.domain.services;


import ec.gob.metrodequito.controlacceso.domain.repositories.UsersRepository;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.UserRol;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {
    private final UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users usuario = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
        System.out.println(usuario);
        String[] roles = usuario.getRoles().stream().map(UserRol::getRole).toArray(String[]::new);
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPasswordHash())
                .roles(roles)
                .authorities(this.grantedAuthorities(roles))
                .accountLocked(usuario.getIsLooked())
                .disabled(usuario.getIsActive())
                .build();
    }

    private String[] getAuthorities(String role){
        if("ADMIN".equals(role) || "CUSTOMER".equals(role)){
            return new String[] {"random_order"};
        }
        return new String[] {};
    }

    private List<GrantedAuthority> grantedAuthorities(String[] roles){
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
        for( String role: roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            for( String authority: this.getAuthorities(role)){
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return authorities;
    }
}
