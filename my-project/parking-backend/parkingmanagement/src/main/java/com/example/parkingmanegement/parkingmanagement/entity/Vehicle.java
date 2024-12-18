package com.example.parkingmanegement.parkingmanagement.entity;


import jakarta.persistence.*;

/**
 * Classe représentant un véhicule dans le système.
 */
@Entity
@Table(name = "vehicles")
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
     * Marque du véhicule.
     */
    @Column(nullable = false)
    private String brand;

    /**
     * Couleur du véhicule.
     */
    @Column(nullable = true)
    private String color;

    /**
     * Type du véhicule (voiture, moto, etc.).
     */
    @Column(nullable = false)
    private String type;

    public Vehicle() {
        super();
    }

    public Vehicle(Long id, String licensePlate, String model, String brand, String color, String type) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.type = type;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


}
