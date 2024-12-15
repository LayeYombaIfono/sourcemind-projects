package projet.park.automobile.gestionparkautomobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.park.automobile.gestionparkautomobile.model.User;
import projet.park.automobile.gestionparkautomobile.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserRepositoryService {

//    INSERTION DE REPOSITORY UTILISATEUR
    @Autowired
    UserRepository userRepository;


    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return List.of();
    }
}
