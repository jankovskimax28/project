package fapi.service;

import fapi.models.TaskViewModel;
import java.util.List;

public interface TaskDataService {

    TaskViewModel saveTask(TaskViewModel task);

    TaskViewModel getTaskById(Integer id);

    List<TaskViewModel> getAll();

    void deleteTask(Integer id);

    List<TaskViewModel> findTaskByOffset(int offset);

    List<TaskViewModel> findTaskByCode(String code);


}
