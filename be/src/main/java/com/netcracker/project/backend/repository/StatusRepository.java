package com.netcracker.project.backend.repository;

import com.netcracker.project.backend.entity.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Integer> {
}