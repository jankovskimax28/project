package com.netcracker.project.backend.repository;

import com.netcracker.project.backend.entity.Priority;
import org.springframework.data.repository.CrudRepository;

public interface PriorityRepository extends CrudRepository<Priority, Integer> {
}