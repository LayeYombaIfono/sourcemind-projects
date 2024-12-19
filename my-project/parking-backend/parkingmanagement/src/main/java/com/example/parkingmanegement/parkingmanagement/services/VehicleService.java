package com.example.parkingmanegement.parkingmanagement.services;


import com.example.parkingmanegement.parkingmanagement.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    //    Ajout et mise à jour
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);

    //    Suppression
    void deleteVehicle(Vehicle vehicle);
    void deleteVehicleById(Long id);

    //    Recuperer
    Vehicle getVehicleById(Long id);
    List<Vehicle> getAllVehicles();


}
