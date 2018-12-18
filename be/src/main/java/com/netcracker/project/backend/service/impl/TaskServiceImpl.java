package com.netcracker.project.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.netcracker.project.backend.entity.Task;
import com.netcracker.project.backend.repository.TaskRepository;
import com.netcracker.project.backend.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {

        this.repository = repository;
    }

    @Override
    public Task saveTask(Task task) {

        return repository.save(task);
    }

    @Override
    public Iterable<Task> getAllTask() {

        return repository.findAll();

    }

    @Override
    public void deleteTask(Integer id){

        repository.deleteById(id);

    }

    @Override
    public List<Task> findTaskByOffset(int offset){

        return repository.findTaskByOffset(offset);

    }

    @Override
    public Optional<Task> getTaskById(Integer id){

        return  repository.findById(id);

    }

    @Override
    public List<Task> findTaskByCode(String code){

        return repository.findTaskByCode(code);

    }

}