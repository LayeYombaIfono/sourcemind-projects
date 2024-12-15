package projet.park.automobile.gestionparkautomobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import projet.park.automobile.gestionparkautomobile.model.ParkingSpot;

import java.util.List;

public class ParkingServiceImpl implements ParkingSpotRepositoryService {

    @Autowired
    ParkingSpotRepositoryService parkingSpotService;

    @Override
    public ParkingSpot findBySpotNumber(String spotNumber) {
        return null;
    }

    @Override
    public List<ParkingSpot> findByIsOccupiedFalse() {
        return List.of();
    }

    @Override
    public List<ParkingSpot> findByIsOccupiedTrue() {
        return List.of();
    }

    @Override
    public boolean existsBySpotNumber(String spotNumber) {
        return false;
    }
}
