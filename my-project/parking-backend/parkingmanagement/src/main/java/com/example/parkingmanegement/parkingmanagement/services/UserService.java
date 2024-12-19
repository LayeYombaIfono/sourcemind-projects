package com.example.parkingmanegement.parkingmanagement.services;

import com.example.parkingmanegement.parkingmanagement.entity.User;

import java.util.List;

public interface UserService {

//    Ajout et mise à jour
    User addUser(User user);
    User updateUser(User user);

//    Suppression
    void deleteUser(User user);
    void deleteUserById(Long id);

//    Recuperer
    User getUserById(Long id);
    List<User> getAllUsers();

    List<User> findByUsername(String username);



}
