package com.example.parkingmanegement.parkingmanagement.services;


import com.example.parkingmanegement.parkingmanagement.entity.Vehicle;
import com.example.parkingmanegement.parkingmanagement.repository.VehicleRepository;

import java.util.List;
import java.util.Optional;

/**
 * Enregistrer un nouveau véhicule.
 */
public class VehicleServices {

    private final VehicleRepository vehicleRepository;


    public VehicleServices(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Enregistrer un nouveau véhicule.
     */
    public Vehicle registerVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    /**
     * Récupérer tous les véhicules.
     */
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    /**
     * Récupérer un véhicule par son ID.
     */
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    /**
     * Récupérer un véhicule par son numéro d'immatriculation.
     */
    public List<Vehicle> getVehicleByLicensePlate(String licensePlate) {
        return vehicleRepository.findByLicensePlate(licensePlate);
    }

    /**
     * Mettre à jour les informations d'un véhicule.
     */
    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        return vehicleRepository.findById(id).map(vehicle -> {
            vehicle.setLicensePlate(updatedVehicle.getLicensePlate());
            vehicle.setModel(updatedVehicle.getModel());
            vehicle.setBrand(updatedVehicle.getBrand());
            vehicle.setColor(updatedVehicle.getColor());
            vehicle.setType(updatedVehicle.getType());
            return vehicleRepository.save(vehicle);
        }).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    /**
     * Supprimer un véhicule par son ID.
     */
    public void deleteVehicle(Long id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Vehicle not found");
        }
    }



}
