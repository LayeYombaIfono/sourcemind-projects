package com.example.parkingmanegement.parkingmanagement.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;

//import org.springframework.security.web.SecurityFilterChain;


/**
 * Configuration pour le chiffrement des mots de passe.
 */

@Configuration
public class SecurityConfig {

    /**
     * Définit un bean PasswordEncoder qui utilise BCrypt pour chiffrer les mots de passe.
     *
     * @return une instance de BCryptPasswordEncoder.
     */

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Désactive CSRF en utilisant le nouveau Customizer
//                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Autorise toutes les requêtes
//        return http.build();
//    }
}
