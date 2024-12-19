package com.example.parkingmanegement.parkingmanagement.services;

import com.example.parkingmanegement.parkingmanagement.entity.ParkingSpot;


import java.util.List;

public interface ParkingSpotService {

    //    Ajout et mise à jour
    ParkingSpot addParkingSpot(ParkingSpot parkingSpot);
    ParkingSpot updateParkingSpot(ParkingSpot parkingSpot);

    //    Suppression
    void deleteParkingSpot(ParkingSpot parkingSpot);
    void deleteParkingSpotById(Long id);

    //    Recuperer
    ParkingSpot getParkingSpotById(Long id);
    List<ParkingSpot> getParkingSpotAlls();
}
