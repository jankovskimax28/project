package com.netcracker.project.backend.service.impl;

import com.netcracker.project.backend.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.netcracker.project.backend.entity.User;
import com.netcracker.project.backend.repository.UserRepository;
import com.netcracker.project.backend.service.PriorityService;

import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceimpl(UserRepository repository) {

        this.repository=repository;
    }

    @Override
    public User saveUser (User user){
        return repository.save(user);
    }

    @Override
    public Iterable<User> getAllUsers ()  {
        return repository.findAll();
    }

    @Override
    public User getOne (String login){

        return repository.findByLogin(login);
    }

}
