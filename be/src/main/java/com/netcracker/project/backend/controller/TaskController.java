package com.netcracker.project.backend.controller;

import com.netcracker.project.backend.entity.Task;
import com.netcracker.project.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/be/pm/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.POST)
    public Task saveTaskEntity(@RequestBody Task task) {

        return taskService.saveTask(task);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Task> getAllTasks() {

        return taskService.getAllTask();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable(name = "id") Integer id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/offset/", method = RequestMethod.GET)
    public List<Task> getTask(@RequestParam (value = "offset") Integer offset){
        return taskService.findTaskByOffset(offset);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> getTaskById(@PathVariable (name = "id") Integer id){
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/code/", method = RequestMethod.GET)
    public List<Task> getTaskByCode(@RequestParam (value = "code") String code){
        return taskService.findTaskByCode(code);
    }
}