package projet.park.automobile.gestionparkautomobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.park.automobile.gestionparkautomobile.model.User;
import projet.park.automobile.gestionparkautomobile.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

//    INSERTION DE REPOSITORY UTILISATEUR
    @Autowired
    UserRepository userRepository;


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
