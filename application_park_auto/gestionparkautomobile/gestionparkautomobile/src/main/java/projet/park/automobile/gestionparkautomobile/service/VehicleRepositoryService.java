package projet.park.automobile.gestionparkautomobile.service;


import projet.park.automobile.gestionparkautomobile.model.Vehicle;

import java.util.List;

public interface VehicleRepositoryService {

    // Trouver un véhicule par sa plaque d'immatriculation
    Vehicle findByLicensePlate(String licensePlate);

    // Vérifier si un véhicule existe avec une plaque d'immatriculation donnée
    boolean existsByLicensePlate(String licensePlate);

    // Trouver tous les véhicules d'un propriétaire donné
    List<Vehicle> findByOwnerName(String ownerName);
}
