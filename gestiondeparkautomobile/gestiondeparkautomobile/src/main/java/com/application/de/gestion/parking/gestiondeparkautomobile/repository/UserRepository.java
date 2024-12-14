package com.application.de.gestion.parking.gestiondeparkautomobile.repository;

import com.application.de.gestion.parking.gestiondeparkautomobile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
