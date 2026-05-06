package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.User;
import pe.edu.upc.apirev.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user = repo.findByUserEmail(email).orElse (null);

        if(user == null){
            throw new UsernameNotFoundException(String.format("Usuario no existe '%s'.", email));
        }

        List<GrantedAuthority> roles =new ArrayList<>();
        user.getRoles().forEach(role->{roles.add(new SimpleGrantedAuthority(role.getNameRole()));
        });
        UserDetails ud = new org.springframework.security.core.userdetails.User(
                user.getUserEmail(),
                user.getUserPassword(),
                user.getEnabled(),
                true,true,true,roles
        );
        return ud;
    }
}
