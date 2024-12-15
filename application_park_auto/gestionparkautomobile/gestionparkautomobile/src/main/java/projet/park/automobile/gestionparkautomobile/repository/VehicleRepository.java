package projet.park.automobile.gestionparkautomobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.park.automobile.gestionparkautomobile.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


}
