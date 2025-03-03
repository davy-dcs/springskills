package fr.descamps.springskills.service.impl;

import fr.descamps.springskills.component.TaskValidator;
import fr.descamps.springskills.domain.Task;
import fr.descamps.springskills.dto.mapper.ITaskMapper;
import fr.descamps.springskills.dto.request.task.TaskRequest;
import fr.descamps.springskills.dto.request.task.TaskRequestTaskTitleRequest;
import fr.descamps.springskills.dto.request.task.TaskTitleRequest;
import fr.descamps.springskills.dto.response.task.TaskResponse;
import fr.descamps.springskills.error.exception.TaskNotFoundException;
import fr.descamps.springskills.error.exception.TaskTitleAlreadyExists;
import fr.descamps.springskills.repositories.ITaskRepository;
import fr.descamps.springskills.service.ITaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements ITaskService {
    private final ITaskRepository taskRepository;
    private final ITaskMapper taskMapper;
    private final TaskValidator taskValidator;

    @Override
    public Page<TaskResponse> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return taskMapper.pageableToPageTaskResponse(taskRepository.findAll(pageable));
    }

    @Override
    public TaskResponse getByTitle(TaskTitleRequest taskTitleRequest) {
        taskValidator.taskTitleRequestValidate(taskTitleRequest);
        return taskMapper.taskToTaskResponse(
                findByTitleOrNotFound(taskTitleRequest)
        );
    }

    @Override
    public TaskResponse create(TaskRequest taskRequest) {
        taskValidator.taskRequestValidate(taskRequest);

        if (taskRepository.existsByTitle(taskRequest.title())) {
            throw new TaskTitleAlreadyExists("Task already exists with title : " + taskRequest.title());
        }

        return taskMapper.taskToTaskResponse(
                    taskRepository.save(
                            taskMapper.taskRequestToTask(taskRequest))
        );
    }

    @Override
    public TaskResponse update(TaskRequestTaskTitleRequest taskRequestTaskTitleRequest) {
        taskValidator.taskTitleRequestValidate(taskRequestTaskTitleRequest.taskTitleRequest());
        taskValidator.taskRequestValidate(taskRequestTaskTitleRequest.taskRequest());

        Task task = findByTitleOrNotFound(taskRequestTaskTitleRequest.taskTitleRequest());
        taskMapper.updatePartialTask(taskRequestTaskTitleRequest.taskRequest(), task);
        return taskMapper.taskToTaskResponse(taskRepository.save(task));
    }

    @Override
    public void delete(TaskTitleRequest taskTitleRequest) {
        taskValidator.taskTitleRequestValidate(taskTitleRequest);
        taskRepository.delete(
                findByTitleOrNotFound(taskTitleRequest)
        );
    }

    private Task findByTitleOrNotFound(TaskTitleRequest taskTitleRequest) {
        return taskRepository.findByTitle(taskTitleRequest.title())
                .orElseThrow(() -> new TaskNotFoundException("Task not found by title : " + taskTitleRequest.title()));
    }
}
