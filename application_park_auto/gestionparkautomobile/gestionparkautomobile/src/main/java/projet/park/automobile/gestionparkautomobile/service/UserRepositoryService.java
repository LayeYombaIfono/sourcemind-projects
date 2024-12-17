package projet.park.automobile.gestionparkautomobile.service;

import projet.park.automobile.gestionparkautomobile.model.User;

import java.util.List;

public interface UserRepositoryService {

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


//    Affichage des utilisateurs

   // List<User>getAllUser();

}
