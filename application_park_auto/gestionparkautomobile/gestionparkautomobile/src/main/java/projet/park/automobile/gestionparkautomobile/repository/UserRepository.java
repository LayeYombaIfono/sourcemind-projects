package projet.park.automobile.gestionparkautomobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.park.automobile.gestionparkautomobile.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
