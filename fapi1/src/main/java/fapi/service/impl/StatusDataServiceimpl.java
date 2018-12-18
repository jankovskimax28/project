package fapi.service.impl;

import fapi.models.RoleViewModel;
import fapi.models.StatusViewModel;
import fapi.service.StatusDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StatusDataServiceimpl implements StatusDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<StatusViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        StatusViewModel[] StatusViewModelResponse = restTemplate.getForObject(backendServerUrl + "/be/pm/status/", StatusViewModel[].class);
        return Arrays.asList(StatusViewModelResponse);
    }
}
