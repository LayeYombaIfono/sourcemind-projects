package projet.park.automobile.gestionparkautomobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.park.automobile.gestionparkautomobile.model.User;
import projet.park.automobile.gestionparkautomobile.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserRepositoryService {

//    INSERTION DE REPOSITORY UTILISATEUR
    @Autowired
    UserRepository userRepository;



}
