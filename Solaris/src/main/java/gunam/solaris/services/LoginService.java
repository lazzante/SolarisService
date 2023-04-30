package gunam.solaris.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

public interface LoginService {
    ResponseEntity<Object> login();

    }
