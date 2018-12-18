package fapi.service.impl;

import fapi.models.TaskViewModel;
import fapi.service.TaskDataService;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Arrays;
import java.util.Collections;

@Service
public class TaskDataServiceimpl implements TaskDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public TaskViewModel saveTask(TaskViewModel task){

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl+"/be/pm/task/", task, TaskViewModel.class).getBody();
    }

    @Override
    public List<TaskViewModel> getAll(){
        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel[] TaskViewModelResponse = restTemplate.getForObject(backendServerUrl + "/be/pm/task/", TaskViewModel[].class);
        return TaskViewModelResponse == null ? Collections.emptyList() : Arrays.asList(TaskViewModelResponse);

    }

    @Override
    public void deleteTask(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/be/pm/task/" + id);
    }

    @Override
    public TaskViewModel getTaskById(Integer id){

        RestTemplate restTemplate = new RestTemplate();

        TaskViewModel TaskViewModelResponse = restTemplate.getForObject(backendServerUrl + "/be/pm/task/" + id, TaskViewModel.class);

        return TaskViewModelResponse;
    }

    @Override
    public List<TaskViewModel>findTaskByOffset(int offset){
        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel[] TaskViewModelResponse = restTemplate.getForObject(backendServerUrl + "/be/pm/task/offset/?offset=" + offset, TaskViewModel[].class);
        return TaskViewModelResponse == null ? Collections.emptyList() : Arrays.asList(TaskViewModelResponse);

    }

    @Override
    public List<TaskViewModel>findTaskByCode(String code){
        RestTemplate restTemplate = new RestTemplate();
        TaskViewModel[] TaskViewModelResponse = restTemplate.getForObject(backendServerUrl + "/be/pm/task/code/?code=" + code, TaskViewModel[].class);
        return TaskViewModelResponse == null ? Collections.emptyList() : Arrays.asList(TaskViewModelResponse);

    }
}
