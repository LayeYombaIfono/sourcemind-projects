package com.example.parkingmanegement.parkingmanagement.controller;

import com.example.parkingmanegement.parkingmanagement.entity.User;
import com.example.parkingmanegement.parkingmanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur pour gérer les opérations liées aux utilisateurs.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    /**
     * Constructeur pour injecter UserService.
     * @param userService instance de UserService.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * Enregistre un nouvel utilisateur dans le système.
     * @param user les détails de l'utilisateur à enregistrer.
     * @return l'utilisateur enregistré.
     */
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    /**
     * Récupère la liste de tous les utilisateurs.
     * @return la liste des utilisateurs.
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * Récupère un utilisateur par son ID.
     * @param id l'identifiant de l'utilisateur.
     * @return l'utilisateur trouvé.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    /**
     * Met à jour un utilisateur existant.
     * @param id l'identifiant de l'utilisateur.
     * @param user les nouvelles informations de l'utilisateur.
     * @return l'utilisateur mis à jour.
     */

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    /**
     * Supprime un utilisateur par son ID.
     * @param id l'identifiant de l'utilisateur.
     * @return une réponse vide en cas de succès.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
