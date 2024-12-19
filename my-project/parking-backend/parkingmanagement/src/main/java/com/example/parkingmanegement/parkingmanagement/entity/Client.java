package com.example.parkingmanegement.parkingmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TABLE_CLIENTS")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nomClient;

    private String adresseClient;
}
