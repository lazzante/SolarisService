package gunam.solaris.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeHttpRequests().requestMatchers("/signUp","/user/**","/authority/**","/title/**").permitAll();


        http.httpBasic().authenticationEntryPoint(new AuthEntryPoint());


        http.authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/login").authenticated()
                .requestMatchers("/").authenticated()
                .requestMatchers("/admin-panel/**").hasAuthority("ADMIN");
        http
                .authorizeHttpRequests().anyRequest().permitAll();



        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
