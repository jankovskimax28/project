package com.netcracker.project.backend.service;

import com.netcracker.project.backend.entity.User;

import java.util.Optional;


public interface UserService {

    User getOne(String login);
    Iterable<User> getAllUsers();
    User saveUser(User user);
}
