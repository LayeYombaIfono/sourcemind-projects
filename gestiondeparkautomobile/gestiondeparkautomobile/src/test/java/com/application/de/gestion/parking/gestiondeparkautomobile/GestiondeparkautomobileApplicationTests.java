package com.application.de.gestion.parking.gestiondeparkautomobile;

import com.application.de.gestion.parking.gestiondeparkautomobile.model.User;
import com.application.de.gestion.parking.gestiondeparkautomobile.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class GestiondeparkautomobileApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
    public void testCreateUser(){
		User user1 = new User("Jean", "jean@gmail.com", "password", "admin", new Date());

		userRepository.save(user1);
	}

}
