package com.netcracker.project.backend.controller;

import com.netcracker.project.backend.entity.Role;
import com.netcracker.project.backend.service.RoleService;
import com.netcracker.project.backend.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/pm/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "roles", method = RequestMethod.GET)
    public Iterable<Role> getAllRls() {
        return roleService.getAllRls();
    }

}
