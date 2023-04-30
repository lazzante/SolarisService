package gunam.solaris.contracts.errors;

import gunam.solaris.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class AuthSuccessRes {

    private User user;

    private Collection<?> authority;

    private Boolean isAuth;






}
