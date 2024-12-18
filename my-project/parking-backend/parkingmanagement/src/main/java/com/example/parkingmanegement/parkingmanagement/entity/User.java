package com.example.parkingmanegement.parkingmanagement.entity;

import jakarta.persistence.*;
//import lombok.*;

import java.time.LocalDateTime;

/**
 * Classe représentant un utilisateur dans le système.
 * Chaque utilisateur a un rôle, des identifiants uniques et un e-mail.
 */
@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter

@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nom d'utilisateur unique pour se connecter.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * Mot de passe de l'utilisateur (doit être sécurisé).
     */
    @Column(nullable = false)
    private String password;

    /**
     * Adresse e-mail de l'utilisateur.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Rôle de l'utilisateur (ex: ADMIN, USER).
     */
    @Column(nullable = false)
    private String role;

    /**
     * Date et heure d'enregistrement de l'utilisateur.
     */
    @Column(nullable = false, updatable = false)
    private LocalDateTime registrationDate;

    /**
     * Initialiser la date d'enregistrement lors de la création.
     */
    @PrePersist
    protected void onCreate() {
        this.registrationDate = LocalDateTime.now();
    }

    public User() {
        super();
    }

    public User(Long id, String username, String password, String email, String role, LocalDateTime registrationDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.registrationDate = registrationDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
