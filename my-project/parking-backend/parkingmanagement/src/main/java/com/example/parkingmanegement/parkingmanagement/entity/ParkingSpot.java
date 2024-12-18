package com.example.parkingmanegement.parkingmanagement.entity;

import jakarta.persistence.*;

/**
 * Représente une place de parking dans le système.
 */
@Entity
@Table(name = "parking_spots")
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Identifiant unique ou numéro de la place de parking.
     */
    @Column(nullable = false, unique = true)
    private String spotNumber;

    /**
     * Indique si la place est occupée ou libre.
     */
    @Column(nullable = false)
    private boolean isOccupied;

    /**
     * Type de véhicule pouvant occuper cette place (optionnel).
     */
    @Column(nullable = true)
    private String vehicleType;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

}
