package fapi.service;

import fapi.models.ProjectViewModel;
import java.util.List;

public interface ProjectDataService {

    ProjectViewModel saveProject(ProjectViewModel project);
    List<ProjectViewModel> getAll();
}
