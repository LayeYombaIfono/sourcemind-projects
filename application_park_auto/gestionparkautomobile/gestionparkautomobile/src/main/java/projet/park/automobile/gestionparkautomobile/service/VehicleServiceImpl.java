package projet.park.automobile.gestionparkautomobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import projet.park.automobile.gestionparkautomobile.model.Vehicle;
import projet.park.automobile.gestionparkautomobile.repository.VehicleRepository;


import java.util.List;

public class VehicleServiceImpl implements VehicleRepositoryService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle findByLicensePlate(String licensePlate) {
        return null;
    }

    @Override
    public boolean existsByLicensePlate(String licensePlate) {
        return false;
    }

    @Override
    public List<Vehicle> findByOwnerName(String ownerName) {
        return List.of();
    }
}
