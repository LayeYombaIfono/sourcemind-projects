package projet.park.automobile.gestionparkautomobile.service;

import projet.park.automobile.gestionparkautomobile.model.User;

import java.util.List;

public interface UserService {

//    Ajout d'un utilisateur
    User addUser(User user);

//    Mise à jour d'un utilisateur
    User updateUser(User user);

//    Supprimer tout les utilisateurs ou un utilisateur par id
    void deleteUser(User user);
    void deleteUserById(Long id);




//    Affichage des utilisateurs
    User getUserById(Long id);
    List<User>getAllUser();

}
