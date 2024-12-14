package projet.park.automobile.gestionparkautomobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.park.automobile.gestionparkautomobile.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
