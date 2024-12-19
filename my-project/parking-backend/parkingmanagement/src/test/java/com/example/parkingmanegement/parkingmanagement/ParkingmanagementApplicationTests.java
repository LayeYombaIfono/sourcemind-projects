package com.example.parkingmanegement.parkingmanagement;

import com.example.parkingmanegement.parkingmanagement.entity.ActivityLog;
import com.example.parkingmanegement.parkingmanagement.entity.ParkingSpot;
import com.example.parkingmanegement.parkingmanagement.entity.User;
import com.example.parkingmanegement.parkingmanagement.entity.Vehicle;
import com.example.parkingmanegement.parkingmanagement.repository.ActivityLogRepository;
import com.example.parkingmanegement.parkingmanagement.repository.ParkingSpotRepository;
import com.example.parkingmanegement.parkingmanagement.repository.UserRepository;

import com.example.parkingmanegement.parkingmanagement.repository.VehicleRepository;
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



//TEST UTINITAIRE PLACE VEHICULE

	@Autowired
	private ParkingSpotRepository parkingSpotRepository;

	@Test
	public void testAddParkingSpot(){
		ParkingSpot parkingSpot1 = new ParkingSpot("PM-001", true);
		ParkingSpot parkingSpot2 = new ParkingSpot("PM-002", true);
		ParkingSpot parkingSpot3 = new ParkingSpot("PM-003", true);
		ParkingSpot parkingSpot4 = new ParkingSpot("PM-004", true);

		parkingSpotRepository.save(parkingSpot1);
		parkingSpotRepository.save(parkingSpot2);
		parkingSpotRepository.save(parkingSpot3);
		parkingSpotRepository.save(parkingSpot4);

		System.out.println(parkingSpotRepository.toString());
	}


	@Test
	public void  testFindParkingSpotById(){
		ParkingSpot parkingSpot = parkingSpotRepository.findById(3L).get();
		System.out.println("Place du Parking Numero : " + parkingSpot.getSpotNumber());
	}


	@Test
	public void  testFindUpdateParkingSpot(){
		ParkingSpot parkingSpot = parkingSpotRepository.findById(4L).get();
		parkingSpot.setOccupied(false);
		parkingSpotRepository.save(parkingSpot);

	}

	@Test
	public void deleteParkingSpot(){
		parkingSpotRepository.deleteById(4L);
	}

	@Test
	public void getParkinSpotAlls(){
		List<ParkingSpot> parkingSpots = parkingSpotRepository.findAll();
		for (ParkingSpot parkingSpot : parkingSpots){
			System.out.println(parkingSpot.toString());
		}
	}

	//TEST UTINITAIRE VEHICULE

	@Autowired
	private VehicleRepository vehicleRepository;

	@Test
	public void testVehicle(){
		//Vehicle vehicle1 = new Vehicle("PK-45458", "BMW", "Laye Yomba", "Blanche", "Diesel");
		Vehicle vehicle2 = new Vehicle("PK-45459", "RAV4", "Jean", "Blanche", "Diesel");
		Vehicle vehicle3 = new Vehicle("PK-45460", "ODULE", "Finda", "Noire", "Diesel");
		Vehicle vehicle4 = new Vehicle("PK-45457", "BMW", "Laye Yomba", "Blanche", "Diesel");
		//vehicleRepository.save(vehicle1);
		vehicleRepository.save(vehicle2);
		vehicleRepository.save(vehicle3);
		vehicleRepository.save(vehicle4);

	}


	@Test
	public void  testFindParkingSpot(){
		Vehicle vehicle = vehicleRepository.findById(1L).get();
		System.out.println("Numero de la plaque du vehicule : " + vehicle.getLicensePlate());
	}


	@Test
	public void  testFindUpdateVehicle(){
		Vehicle vehicle = vehicleRepository.findById(3L).get();
		vehicle.setFuelType("Essence");
		vehicleRepository.save(vehicle);
		System.out.println("Type de carburant modifier : " + vehicle.getFuelType());
	}

	@Test
	public void deleteVehicle(){
		vehicleRepository.deleteById(5L);
	}

	@Test
	public void getVehicleAlls(){
		List<Vehicle>vehicles = vehicleRepository.findAll();

		for (Vehicle vehicle: vehicles){
			System.out.println(vehicle.toString());
		}
	}


//	TEST UNITAIRE JOURNAL D'ACTIVITE
	@Autowired
	private ActivityLogRepository activityLogRepository;

	@Test
	public void addActivityLog(){
		ActivityLog activityLog1 = new ActivityLog( new Date(), new Date());
		ActivityLog activityLog2 = new ActivityLog( new Date(), new Date());
		ActivityLog activityLog3 = new ActivityLog( new Date(), new Date());

		activityLogRepository.save(activityLog1);
		activityLogRepository.save(activityLog2);
		activityLogRepository.save(activityLog3);

		System.out.println(activityLogRepository.toString());


	}


	@Test
	public void getActivityLogAlls(){
		List<ActivityLog> activityLogs = activityLogRepository.findAll();

		for (ActivityLog activityLog : activityLogs){
			System.out.println(activityLog.toString());
		}

	}







}
