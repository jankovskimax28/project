package fapi.controller;

import fapi.models.TaskViewModel;
import fapi.service.TaskDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pm/task")
public class TaskDataController {

    @Autowired
    private TaskDataService taskDataService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TaskViewModel> saveProject(@RequestBody TaskViewModel task) {
        if (task != null) {
            return ResponseEntity.ok(taskDataService.saveTask(task));
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TaskViewModel>> getAll(){

        return ResponseEntity.ok(taskDataService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBillingAccount(@PathVariable String id) {

        taskDataService.deleteTask(Integer.valueOf(id));
    }

    @RequestMapping(value = "/offset/", method = RequestMethod.GET)
    public ResponseEntity<List<TaskViewModel>> getTasks(@RequestParam(value = "offset") int offset){
        return ResponseEntity.ok(taskDataService.findTaskByOffset(offset));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TaskViewModel> getTaskById(@PathVariable Integer id){

        return ResponseEntity.ok(taskDataService.getTaskById(id));
    }

    @RequestMapping(value = "/code/", method = RequestMethod.GET)
    public ResponseEntity<List<TaskViewModel>> getTasksByCode(@RequestParam(value = "code") String code){
        return ResponseEntity.ok(taskDataService.findTaskByCode(code));
    }

}

