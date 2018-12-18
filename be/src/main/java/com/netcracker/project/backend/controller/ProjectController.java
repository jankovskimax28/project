package com.netcracker.project.backend.controller;

import com.netcracker.project.backend.entity.Project;
import com.netcracker.project.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/pm/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;


    @RequestMapping(method = RequestMethod.POST)
    public Project saveProjectEntity(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public Iterable<Project> getAllProject(){
      return projectService.getAllProject();
    }
}