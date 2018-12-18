package com.netcracker.project.backend.service;

import com.netcracker.project.backend.entity.Task;
import java.util.List;

import java.util.Optional;

public interface TaskService {

    Task saveTask(Task task);

    Iterable<Task> getAllTask();

    void deleteTask(Integer id);

    List<Task> findTaskByOffset(int offset);

    Optional<Task> getTaskById(Integer id);

    List<Task> findTaskByCode(String code);

}
