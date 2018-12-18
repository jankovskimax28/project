package com.netcracker.project.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.netcracker.project.backend.entity.Role;
import com.netcracker.project.backend.repository.RoleRepository;
import com.netcracker.project.backend.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository){

        this.repository = repository;
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public Optional<Role> getRole(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Role> getAllRls() {
        return repository.findAll();
    }
}
