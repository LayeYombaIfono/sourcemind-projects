package com.example.parkingmanegement.parkingmanagement.services;


import com.example.parkingmanegement.parkingmanagement.entity.Vehicle;
import com.example.parkingmanegement.parkingmanagement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Enregistrer un nouveau véhicule.
 */
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }

    @Override
    public void deleteVehicleById(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).get();
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}
