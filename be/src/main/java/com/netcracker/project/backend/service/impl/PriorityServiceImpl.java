package com.netcracker.project.backend.service.impl;

import com.netcracker.project.backend.entity.Priority;
import com.netcracker.project.backend.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.netcracker.project.backend.service.PriorityService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriorityServiceImpl implements PriorityService {

    private PriorityRepository repository;

    @Autowired
    public PriorityServiceImpl(PriorityRepository repository){
        this.repository = repository;
    }


    @Override
    public Iterable<Priority> getAllPriority() {
        return repository.findAll();
    }
}
