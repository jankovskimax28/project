package fapi.service.impl;

import fapi.models.ProjectViewModel;
import fapi.service.ProjectDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

@Service
public class ProjectDataServiceimpl implements ProjectDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public ProjectViewModel saveProject(ProjectViewModel project) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/pm/project", project, ProjectViewModel.class).getBody();
    }

    @Override
    public List<ProjectViewModel> getAll(){
        RestTemplate restTemplate = new RestTemplate();
        ProjectViewModel[] ProjectViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/pm/project/", ProjectViewModel[].class);
        return ProjectViewModelResponse == null ? Collections.emptyList() : Arrays.asList(ProjectViewModelResponse);
        }
}

