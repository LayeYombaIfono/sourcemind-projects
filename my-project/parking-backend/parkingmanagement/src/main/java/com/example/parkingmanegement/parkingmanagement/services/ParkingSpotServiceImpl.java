package com.example.parkingmanegement.parkingmanagement.services;

import com.example.parkingmanegement.parkingmanagement.entity.ParkingSpot;
import com.example.parkingmanegement.parkingmanagement.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Gère les opérations liées aux places de parking.
 */
@Service
public class ParkingSpotServiceImpl implements ParkingSpotService {


    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    @Override
    public ParkingSpot addParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }

    @Override
    public ParkingSpot updateParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }

    @Override
    public void deleteParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotRepository.delete(parkingSpot);
    }

    @Override
    public void deleteParkingSpotById(Long id) {
        parkingSpotRepository.deleteById(id);
    }

    @Override
    public ParkingSpot getParkingSpotById(Long id) {
        return parkingSpotRepository.findById(id).get();
    }

    @Override
    public List<ParkingSpot> getParkingSpotAlls() {
        return parkingSpotRepository.findAll();
    }
}
