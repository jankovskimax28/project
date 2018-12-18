package fapi.controller;

import fapi.models.ProjectViewModel;
import fapi.service.ProjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pm/project")
public class ProjectDataController {

    @Autowired
    private ProjectDataService projectDataService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProjectViewModel> saveProject(@RequestBody ProjectViewModel project1) {
        if (project1 != null) {
            return ResponseEntity.ok(projectDataService.saveProject(project1));
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProjectViewModel>> getAllProject(){
        return ResponseEntity.ok(projectDataService.getAll());
    }
}



