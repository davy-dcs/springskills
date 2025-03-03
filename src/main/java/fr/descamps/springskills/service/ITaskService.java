package fr.descamps.springskills.service;

import fr.descamps.springskills.dto.request.task.TaskRequest;
import fr.descamps.springskills.dto.request.task.TaskRequestTaskTitleRequest;
import fr.descamps.springskills.dto.request.task.TaskTitleRequest;
import fr.descamps.springskills.dto.response.task.TaskResponse;
import org.springframework.data.domain.Page;

public interface ITaskService {
    Page<TaskResponse> getAll(Integer page, Integer size);
    TaskResponse getByTitle(TaskTitleRequest taskTitleRequest);
    TaskResponse create(TaskRequest taskRequest);
    TaskResponse update(TaskRequestTaskTitleRequest taskRequestTaskTitleRequest);
    void delete(TaskTitleRequest taskTitleRequest);
}
