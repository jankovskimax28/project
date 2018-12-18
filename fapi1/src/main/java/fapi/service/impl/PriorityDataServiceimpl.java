package fapi.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import fapi.models.PriorityViewModel;
import fapi.service.PriorityDataService;

import java.util.List;
import java.util.Arrays;

@Service
public class PriorityDataServiceimpl implements PriorityDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<PriorityViewModel> getAll(){
        RestTemplate restTemplate = new RestTemplate();
        PriorityViewModel[] PriorityViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/pm/priority/", PriorityViewModel[].class);
        return Arrays.asList(PriorityViewModelResponse);
    }
}
