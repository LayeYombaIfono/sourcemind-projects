package projet.park.automobile.gestionparkautomobile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import projet.park.automobile.gestionparkautomobile.model.User;
import projet.park.automobile.gestionparkautomobile.repository.UserRepository;

import java.util.Date;
import java.util.List;

@SpringBootTest
class GestionparkautomobileApplicationTests {



//    @Test
//	void contextLoads() {
//	}

	@Autowired
	private  UserRepository userRepository;


//	Jouter un utilisateur
	@Test
	public void testCreateUser(){
		User user = new User("Moussa", "moussa@gmail.com", "passwordM", "user", new Date());

		userRepository.save(user);

	}

//	Afficher un produit par id
	@Test
	public void testDisplayUserById(){
		User idUser = userRepository.findById(1L).get();
		System.out.println(idUser);
	}

	//	Modifier un utilisateur
	@Test
	public void testUpdate(){
		User userUpdate = userRepository.findById(1L).get();
		userUpdate.setUsername("John Doe");
		userRepository.save(userUpdate);
		System.out.println(userUpdate);
	}

//	Supprimer un utilisateur
@Test
	public void deleteUser(){
		userRepository.deleteById(2L);
}

//Afficher tout les produits

	@Test
	public void displayAllUsers(){

		List<User>userList = userRepository.findAll();

		for (User user: userList){
			System.out.println("Nom: " + user.getUsername() + "\nEmail: " + user.getEmail());
		}
	}

//	Supprimer tout les utilisateur
	@Test
	public void deleteAllUsers(){
		userRepository.deleteAll();
	}



}
