package com.netcracker.project.backend.service.impl;


import com.netcracker.project.backend.entity.Status;
import com.netcracker.project.backend.repository.StatusRepository;
import com.netcracker.project.backend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusRepository repository;

    @Autowired
    public StatusServiceImpl(StatusRepository repository){
        this.repository = repository;
    }


    @Override
    public Iterable<Status> getAllStatus() {
        return repository.findAll();
    }
}
