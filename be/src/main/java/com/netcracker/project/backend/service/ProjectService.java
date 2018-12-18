package com.netcracker.project.backend.service;

import com.netcracker.project.backend.entity.Project;
import java.util.Optional;

public interface ProjectService {
    Project saveProject(Project project);
    Iterable<Project> getAllProject();

}
