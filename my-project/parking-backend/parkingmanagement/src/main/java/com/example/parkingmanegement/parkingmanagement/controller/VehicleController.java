package com.example.parkingmanegement.parkingmanagement.controller;

import com.example.parkingmanegement.parkingmanagement.entity.Vehicle;
import com.example.parkingmanegement.parkingmanagement.repository.VehicleRepository;
import com.example.parkingmanegement.parkingmanagement.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur pour gérer les opérations liées aux véhicules.
 */
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    /**
     * Enregistrer un nouveau véhicule.
     * @param vehicle les informations du véhicule à enregistrer.
     * @return le véhicule enregistré.
     */
    @PostMapping("/register")
    public ResponseEntity<Vehicle> registerVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.registerVehicle(vehicle));
    }

    /**
     * Récupérer tous les véhicules.
     * @return une liste de véhicules.
     */
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    /**
     * Récupérer un véhicule par son ID.
     * @param id l'identifiant du véhicule.
     * @return le véhicule correspondant.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Mettre à jour les informations d'un véhicule.
     * @param id l'identifiant du véhicule.
     * @param vehicle les nouvelles informations du véhicule.
     * @return le véhicule mis à jour.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicle));
    }

    /**
     * Supprimer un véhicule par son ID.
     * @param id l'identifiant du véhicule.
     * @return une réponse vide en cas de succès.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }




}
