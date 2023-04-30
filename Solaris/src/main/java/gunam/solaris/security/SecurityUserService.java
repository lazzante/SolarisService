package gunam.solaris.security;

import gunam.solaris.entities.User;
import gunam.solaris.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityUserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundInDb = userRepository.findUserByUsername(username);

        if (foundInDb==null){
            throw new UsernameNotFoundException("User Not Found");
        }

        return new SecurityUserDetails(foundInDb);
        //EĞER UserDetails CLASSINI User NESNESİNE EKLERSEYDİK DİREKT OLARAK USERDA DÖNEBİLİRDİK.

    }
}
