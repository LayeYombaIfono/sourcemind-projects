package com.example.parkingmanegement.parkingmanagement.controller;

import com.example.parkingmanegement.parkingmanagement.entity.ParkingSpot;
import com.example.parkingmanegement.parkingmanagement.service.ParkingSpotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API REST pour gérer les places de parking.
 */
@RestController
@RequestMapping("/api/parking-spots")
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping
    public ResponseEntity<ParkingSpot> addParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        ParkingSpot newSpot = parkingSpotService.addParkingSpot(parkingSpot);
        return new ResponseEntity<>(newSpot, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpot>> getAllParkingSpots() {
        List<ParkingSpot> spots = parkingSpotService.getAllParkingSpots();
        return new ResponseEntity<>(spots, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpot> getParkingSpotById(@PathVariable Long id) {
        return parkingSpotService.getParkingSpotByNumber(id.toString())
                .map(spot -> new ResponseEntity<>(spot, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpot> updateParkingSpot(@PathVariable Long id, @RequestBody ParkingSpot parkingSpot) {
        ParkingSpot updatedSpot = parkingSpotService.updateParkingSpot(id, parkingSpot);
        return new ResponseEntity<>(updatedSpot, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingSpot(@PathVariable Long id) {
        parkingSpotService.deleteParkingSpot(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
