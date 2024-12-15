package projet.park.automobile.gestionparkautomobile.service;

import projet.park.automobile.gestionparkautomobile.model.User;

import java.util.List;

public interface UserRepositoryService {

    // Trouver un utilisateur par son nom d'utilisateur
    User findByUsername(String username);

    // Trouver un utilisateur par son email
    User findByEmail(String email);

    // Vérifier si un utilisateur existe avec un nom d'utilisateur donné
    boolean existsByUsername(String username);

    // Vérifier si un utilisateur existe avec un email donné
    boolean existsByEmail(String email);


//    Affichage des utilisateurs

    List<User>getAllUser();

}
