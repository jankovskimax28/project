package fapi.service.impl;

import fapi.models.RoleViewModel;
import fapi.service.RoleDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RoleDataServiceimpl implements RoleDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<RoleViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        RoleViewModel[] RoleViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/pm/role/roles", RoleViewModel[].class);
        return Arrays.asList(RoleViewModelResponse);
    }

}
