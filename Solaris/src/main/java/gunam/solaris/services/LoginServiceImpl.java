package gunam.solaris.services;

import gunam.solaris.contracts.errors.ApiError;
import gunam.solaris.contracts.errors.AuthSuccessRes;
import gunam.solaris.entities.User;
import gunam.solaris.repositories.UserRepository;
import gunam.solaris.security.SecurityUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;



    @Override
    public ResponseEntity<Object> login() {

        Boolean isAuthenticated =SecurityContextHolder.getContext().getAuthentication().isAuthenticated();


        //SecurityUserService CLASSININ DBDEN BULUP SecurityUserDetails'a GONDERDIGI OBJEYE ERISIM.
        SecurityUserDetails userDetails = (SecurityUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        String username = userDetails.getUsername();
        String password = userDetails.getPassword();
        Collection<?> authorities = userDetails.getAuthorities();

        User foundUserInDB = userRepository.findUserByUsername(username);

        AuthSuccessRes res = new AuthSuccessRes(foundUserInDB,authorities,isAuthenticated);


        return ResponseEntity.ok(res);

    }


}
