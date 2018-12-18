package com.netcracker.project.backend.controller;


import com.netcracker.project.backend.entity.Status;
import com.netcracker.project.backend.service.RoleService;
import com.netcracker.project.backend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/be/pm/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Status> getAllRls() {

        return statusService.getAllStatus();
    }

}
