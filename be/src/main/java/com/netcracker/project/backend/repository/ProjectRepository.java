package com.netcracker.project.backend.repository;

import com.netcracker.project.backend.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
