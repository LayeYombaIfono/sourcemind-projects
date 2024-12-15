package projet.park.automobile.gestionparkautomobile.service;

import projet.park.automobile.gestionparkautomobile.model.ParkingSpot;

import java.util.List;

public interface ParkingSpotRepositoryService {
    // Trouver une place de parking par son numéro
    ParkingSpot findBySpotNumber(String spotNumber);

    // Trouver toutes les places libres
    List<ParkingSpot> findByIsOccupiedFalse();

    // Trouver toutes les places occupées
    List<ParkingSpot> findByIsOccupiedTrue();

    // Vérifier si une place existe avec un numéro donné
    boolean existsBySpotNumber(String spotNumber);
}
