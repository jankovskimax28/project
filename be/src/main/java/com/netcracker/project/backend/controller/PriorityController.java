package com.netcracker.project.backend.controller;

import com.netcracker.project.backend.entity.Priority;
import com.netcracker.project.backend.service.impl.PriorityServiceImpl;
import com.netcracker.project.backend.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pm/priority")
public class PriorityController {

    @Autowired
    private PriorityService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Priority> getAllPriority(){
        return service.getAllPriority();
    }
}


