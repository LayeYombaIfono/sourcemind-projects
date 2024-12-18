package com.example.parkingmanegement.parkingmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@ComponentScan(basePackages = {"com.parkingmanagement"})
@SpringBootApplication(scanBasePackages = "com.example.parkingmanegement")
public class ParkingmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingmanagementApplication.class, args);
	}

}
