package fr.descamps.springskills.service.impl;

import fr.descamps.springskills.component.TaskValidator;
import fr.descamps.springskills.domain.Task;
import fr.descamps.springskills.dto.mapper.ITaskMapper;
import fr.descamps.springskills.dto.request.task.TaskRequest;
import fr.descamps.springskills.dto.request.task.TaskTitleRequest;
import fr.descamps.springskills.dto.response.task.TaskResponse;
import fr.descamps.springskills.error.exception.TaskNotFoundException;
import fr.descamps.springskills.repositories.ITaskRepository;
import fr.descamps.springskills.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements ITaskService {
    private final ITaskRepository taskRepository;
    private final ITaskMapper taskMapper;
    private final TaskValidator taskValidator;

    @Override
    public List<TaskResponse> getAll() {
        return taskMapper.tasksToTaskResponseList(taskRepository.findAll());
    }

    @Override
    public TaskResponse getByTitle(TaskTitleRequest taskTitleRequest) {
        return taskMapper.taskToTaskResponse(
                findByTitleOrNotFound(taskTitleRequest)
        );
    }

    @Override
    public TaskResponse create(TaskRequest taskRequest) {
        taskValidator.taskRequestValidate(taskRequest);
        return taskMapper.taskToTaskResponse(
                taskRepository.save(
                        taskMapper.taskRequestToTask(taskRequest))
        );
    }

    @Override
    public TaskResponse update(TaskTitleRequest taskTitleRequest, TaskRequest taskRequest) {
        Task task = findByTitleOrNotFound(taskTitleRequest);
        taskMapper.updatePartialTask(taskRequest, task);
        return taskMapper.taskToTaskResponse(taskRepository.save(task));
    }

    @Override
    public void delete(TaskTitleRequest taskTitleRequest) {
        taskRepository.delete(
                findByTitleOrNotFound(taskTitleRequest)
        );
    }

    private Task findByTitleOrNotFound(TaskTitleRequest taskTitleRequest) {
        taskValidator.taskTitleRequestValidate(taskTitleRequest);
        return taskRepository.findByTitle(taskTitleRequest.title())
                .orElseThrow(() -> new TaskNotFoundException("Task not found by title : " + taskTitleRequest.title()));
    }
}
