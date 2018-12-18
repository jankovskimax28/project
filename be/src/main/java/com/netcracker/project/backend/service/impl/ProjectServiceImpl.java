package com.netcracker.project.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.netcracker.project.backend.entity.Project;
import com.netcracker.project.backend.repository.ProjectRepository;
import com.netcracker.project.backend.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.Optional;

 @Service
 public class ProjectServiceImpl implements ProjectService{

    private ProjectRepository repository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Project saveProject (Project project) {
        return repository.save(project);
    }

    @Override

     public Iterable<Project> getAllProject (){
        return repository.findAll();
    }


}
