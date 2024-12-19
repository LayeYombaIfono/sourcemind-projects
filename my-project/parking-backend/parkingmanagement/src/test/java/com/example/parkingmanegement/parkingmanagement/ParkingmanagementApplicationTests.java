package com.example.parkingmanegement.parkingmanagement;

import com.example.parkingmanegement.parkingmanagement.entity.User;
import com.example.parkingmanegement.parkingmanagement.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Date;
import java.util.List;

@SpringBootTest
class ParkingmanagementApplicationTests {

//	@Test
//	void contextLoads() {
//	}

	@Autowired
	private UserRepository userRepository;


	/**
	 * Test pour ajouter un produit
	 */
	@Test
	public void testAddUser(){
		User user1 = new User("Jean", "jean@gmail.com", "password123", "Admin", new Date());
		User user2 = new User("Paul", "paul14552565", "paul@gmail.com", "user", new Date());
		User user3 = new User("Christine", "christine@@gmail.com", "4567895", "User", new Date());
		User user4 = new User("Laye Yomba Ifono", "ifono@gmail.com", "123456789", "Manager", new Date());
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
	}


	/**
	 * Afficher l'utilisateur par son id
	 */
	@Test
	public void  testFindUser(){
		User user = userRepository.findById(1L).get();
		System.out.println("Nom d'utilisateur : " + user.getUsername());
	}

	/**
	 * Modifier l'utilisateur
	 */
	@Test
	public void  testFindUpdateUser(){
		User user = userRepository.findById(1L).get();
		user.setUsername("Finda Ifono");
		userRepository.save(user);
		System.out.println("Nom d'utilisateur modifier : " + user.getUsername());
	}


	/**
	 * Supprimer un utilisateur
	 */
	@Test
	public void  testDeleteUser(){
		userRepository.deleteById(4L);
	}

/**
 * Afficher tout les utilisateur
 */

@Test
public void testGetAllUser(){
	List<User> users = userRepository.findAll();
	System.out.println("<------Liste des utilisateur-------->");
	for (User user: users){
		System.out.println(user.toString());
	}
	System.out.println("Total : " + users.size());
}














}
