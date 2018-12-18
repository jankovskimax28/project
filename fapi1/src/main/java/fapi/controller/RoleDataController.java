package fapi.controller;

import fapi.models.RoleViewModel;
import fapi.service.RoleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pm/role")
public class RoleDataController {

    @Autowired
    private RoleDataService roleDataService;

    @RequestMapping
    public ResponseEntity<List<RoleViewModel>> getAllRolies() {
        return ResponseEntity.ok(roleDataService.getAll());
    }
}