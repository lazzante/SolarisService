package gunam.solaris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/*@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
 */

@SpringBootApplication
public class SolarisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolarisApplication.class, args);
    }

}
