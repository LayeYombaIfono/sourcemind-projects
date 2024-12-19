package com.example.parkingmanegement.parkingmanagement.controller;


import com.example.parkingmanegement.parkingmanagement.entity.User;
import com.example.parkingmanegement.parkingmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserRestController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    List<User> getAllUsers(){
        return  userService.getAllUsers();
    }




}
