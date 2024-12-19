package com.example.parkingmanegement.parkingmanagement.services;

import com.example.parkingmanegement.parkingmanagement.entity.ParkingSpot;
import com.example.parkingmanegement.parkingmanagement.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Gère les opérations liées aux places de parking.
 */
@Service
public class ParkingSpotServices {
    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotServices(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    /**
     * Ajouter une nouvelle place de parking.
     */
    public ParkingSpot addParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }

    /**
     * Récupérer toutes les places de parking.
     */
    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotRepository.findAll();
    }

    /**
     * Récupérer une place par son numéro.
     */
    public Optional<ParkingSpot> getParkingSpotByNumber(String spotNumber) {
        return parkingSpotRepository.findBySpotNumber(spotNumber);
    }

    /**
     * Mettre à jour une place de parking.
     */
    public ParkingSpot updateParkingSpot(Long id, ParkingSpot updatedParkingSpot) {
        return parkingSpotRepository.findById(id).map(parkingSpot -> {
            parkingSpot.setSpotNumber(updatedParkingSpot.getSpotNumber());
            parkingSpot.setOccupied(updatedParkingSpot.isOccupied());
            parkingSpot.setVehicleType(updatedParkingSpot.getVehicleType());
            return parkingSpotRepository.save(parkingSpot);
        }).orElseThrow(() -> new IllegalArgumentException("Place de parking introuvable."));
    }

    /**
     * Supprimer une place de parking.
     */
    public void deleteParkingSpot(Long id) {
        parkingSpotRepository.deleteById(id);
    }



}
