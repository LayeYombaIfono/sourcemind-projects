package com.example.parkingmanegement.parkingmanagement.service;

import com.example.parkingmanegement.parkingmanagement.entity.User;
import com.example.parkingmanegement.parkingmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour gérer les utilisateurs et encapsuler la logique métier.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructeur pour injecter les dépendances nécessaires.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Enregistrer un nouvel utilisateur.
     * @param user L'utilisateur à enregistrer.
     * @return L'utilisateur enregistré.
     */
    public User registerUser(User user) {
        // Aucun encodage pour le moment
        return userRepository.save(user);
    }

    /**
     * Récupérer tous les utilisateurs.
     * @return Une liste de tous les utilisateurs.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Récupérer un utilisateur par ID.
     * @param id L'ID de l'utilisateur.
     * @return L'utilisateur correspondant.
     * @throws RuntimeException si l'utilisateur n'est pas trouvé.
     */
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Mettre à jour un utilisateur existant.
     * @param id L'ID de l'utilisateur à mettre à jour.
     * @param updatedUser Les nouvelles informations de l'utilisateur.
     * @return L'utilisateur mis à jour.
     * @throws RuntimeException si l'utilisateur n'est pas trouvé.
     */
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setRole(updatedUser.getRole());
            if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
                user.setPassword(updatedUser.getPassword()); // Aucun encodage pour le moment
            }
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Supprimer un utilisateur par ID.
     * @param id L'ID de l'utilisateur à supprimer.
     * @throws RuntimeException si l'utilisateur n'existe pas.
     */
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
