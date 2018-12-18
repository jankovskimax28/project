package fapi.controller;

import  fapi.models.PriorityViewModel;
import  fapi.service.PriorityDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pm/priority")
public class PriorityDataController {

    @Autowired
    private PriorityDataService priorityDataService;

    @RequestMapping
    public ResponseEntity<List<PriorityViewModel>> getAllPriority() {
        return ResponseEntity.ok(priorityDataService.getAll());
    }
}



