package com.example.parkingmanegement.parkingmanagement.repository;

import com.example.parkingmanegement.parkingmanagement.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository pour gérer les opérations CRUD des véhicules.
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByLicensePlate(String licensePlate);
}
