package com.example.parkingmanegement.parkingmanagement.entity;


import jakarta.persistence.*;

import java.util.List;

/**
 * Classe représentant un véhicule dans le système.
 */
@Entity
@Table(name = "TABLE_VEHICULE")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Numéro d'immatriculation unique du véhicule.
     */
    @Column(nullable = false, unique = true)
    private String licensePlate;

    /**
     * Modèle du véhicule.
     */
    @Column(nullable = false)
    private String model;

    /**
     * Proprietaire
     */
    @Column(nullable = false)
    private String ownerName;


    /**
     * Couleur du véhicule.
     */
    @Column()
    private String color;

    /**
     * Type du véhicule (voiture, moto, etc.).
     */
    @Column(nullable = false)
    private String fuelType;



//    CONSTRUCTEUR

    public Vehicle() {
        super();
    }


    public Vehicle(String licensePlate, String model, String ownerName, String color, String fuelType) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.ownerName = ownerName;
        this.color = color;
        this.fuelType = fuelType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + ownerName + '\'' +
                ", color='" + color + '\'' +
                ", type='" + fuelType + '\'' +
                '}';
    }


}
