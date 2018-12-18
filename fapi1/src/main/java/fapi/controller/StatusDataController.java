package fapi.controller;

import fapi.models.StatusViewModel;
import fapi.service.StatusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pm/status")
public class StatusDataController {

    @Autowired
    private StatusDataService statusDataService;

    @RequestMapping
    public ResponseEntity<List<StatusViewModel>> getAllStatus() {
        return ResponseEntity.ok(statusDataService.getAll());
    }
}