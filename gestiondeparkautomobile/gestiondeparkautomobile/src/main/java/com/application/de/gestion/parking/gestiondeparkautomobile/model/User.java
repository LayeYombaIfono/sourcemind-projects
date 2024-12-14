package com.application.de.gestion.parking.gestiondeparkautomobile.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Table(name = "TABLE_UTILISATEUR")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

   // @Column(nullable = false, unique = true)
    private String username;

   // @Column(nullable = false, unique = true)
    private String email;

   // @Column(nullable = false)
    private String password;

    //@Column(nullable = false, unique = true)
    private String role;

    //@Column()
    private LocalDateTime created_at;


//    CONSTRUCTOR
    public User() {
    }

    public User(String jean, String mail, String password, String admin, Date date) {
    }


//GETTERS SETTER


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
