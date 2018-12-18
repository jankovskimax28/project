package com.netcracker.project.backend.repository;

import com.netcracker.project.backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByLogin(String login);

}
