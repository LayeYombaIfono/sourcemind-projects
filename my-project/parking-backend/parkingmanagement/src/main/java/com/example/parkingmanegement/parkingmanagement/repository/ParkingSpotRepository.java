package com.example.parkingmanegement.parkingmanagement.repository;

import com.example.parkingmanegement.parkingmanagement.entity.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
    Optional<ParkingSpot> findBySpotNumber(String spotNumber);

}
