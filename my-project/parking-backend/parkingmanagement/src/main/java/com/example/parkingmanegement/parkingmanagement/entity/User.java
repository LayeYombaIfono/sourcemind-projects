package com.example.parkingmanegement.parkingmanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TABLE_UTILISATEUR")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;


    @Column(nullable = false)
    private String role;

    @Column(nullable = false, updatable = false)
    private Date registrationDate;

    @PrePersist
    protected void onCreate() {
        this.registrationDate = new Date();
    }



//    CONSTRUCTEUR


    public User() {
        super();
    }

    public User( String username, String password, String email, String role, Date registrationDate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.registrationDate = registrationDate;
    }

    // Getters et setters
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
