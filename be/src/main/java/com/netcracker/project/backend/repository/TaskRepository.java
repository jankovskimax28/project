package com.netcracker.project.backend.repository;

import com.netcracker.project.backend.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.awt.print.Pageable;
import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    @Query(value="SELECT * FROM task LIMIT  5  OFFSET  ?1",
    nativeQuery = true)
    List<Task> findTaskByOffset(int offset);

    @Query(value ="SELECT * FROM task WHERE ticet_code LIKE %?1%",
    nativeQuery = true)
    List<Task> findTaskByCode(String code);
}
