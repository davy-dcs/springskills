package fr.descamps.springskills.controller;

import fr.descamps.springskills.dto.request.task.TaskRequest;
import fr.descamps.springskills.dto.request.task.TaskTitleRequest;
import fr.descamps.springskills.dto.response.task.TaskResponse;
import fr.descamps.springskills.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
    private final ITaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(TaskRequest taskRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(taskRequest));
    }

    @PatchMapping
    public ResponseEntity<TaskResponse> update(TaskTitleRequest taskTitleRequest, TaskRequest taskRequest) {
        return ResponseEntity.ok(taskService.update(taskTitleRequest, taskRequest));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(TaskTitleRequest taskTitleRequest) {
        taskService.delete(taskTitleRequest);
        return ResponseEntity.ok().build();
    }
}
