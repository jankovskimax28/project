package com.netcracker.project.backend.controller;

import com.netcracker.project.backend.entity.User;
import com.netcracker.project.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/be/pm/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public User saveUserEntity(@RequestBody User user){

        return userService.saveUser(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<User> getAllProjects(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public User getUserByLogin(@RequestParam (value = "login") String login) {
        User user = userService.getOne(login);
            return user ;

        }
}

