package com.example.parkingmanegement.parkingmanagement.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Configuration pour le chiffrement des mots de passe.
 */

@Configuration
public class SecurityConfig {

    /**
     * Définit un bean PasswordEncoder qui utilise BCrypt pour chiffrer les mots de passe.
     * @return une instance de BCryptPasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher(new AntPathRequestMatcher("/**"))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/register").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(withDefaults());
        return http.build();
    }



   /* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactiver CSRF pour le développement
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/register", "/h2-console/**").permitAll() // Autoriser certaines URL
                        .anyRequest().authenticated()
                )
               .httpBasic(); // Utiliser l'authentification HTTP Basic pour simplifier

        return http.build();
    }

    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
        return username -> org.springframework.security.core.userdetails.User
                .withUsername("admin") // Nom d'utilisateur par défaut
                .password(passwordEncoder().encode("admin123")) // Mot de passe
                .roles("ADMIN") // Rôle de l'utilisateur
                .build();
    }
    */
}
