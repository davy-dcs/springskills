package fr.descamps.springskills.service;

import fr.descamps.springskills.dto.request.task.TaskRequest;
import fr.descamps.springskills.dto.request.task.TaskTitleRequest;
import fr.descamps.springskills.dto.response.task.TaskResponse;

import java.util.List;

public interface ITaskService {
    List<TaskResponse> getAll();
    TaskResponse getByTitle(TaskTitleRequest taskTitleRequest);
    TaskResponse create(TaskRequest taskRequest);
    TaskResponse update(TaskTitleRequest taskTitleRequest, TaskRequest taskRequest);
    void delete(TaskTitleRequest taskTitleRequest);
}
