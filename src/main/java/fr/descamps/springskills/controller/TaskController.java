package fr.descamps.springskills.controller;

import fr.descamps.springskills.dto.request.task.TaskRequest;
import fr.descamps.springskills.dto.request.task.TaskTitleRequest;
import fr.descamps.springskills.dto.response.task.TaskResponse;
import fr.descamps.springskills.service.ITaskService;
import jakarta.validation.Valid;
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

    @GetMapping("/title")
    public ResponseEntity<TaskResponse> getByTitle(@Valid @RequestBody TaskTitleRequest taskTitleRequest) {
        return ResponseEntity.ok(taskService.getByTitle(taskTitleRequest));
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(@Valid @RequestBody TaskRequest taskRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(taskRequest));
    }

    @PatchMapping
    public ResponseEntity<TaskResponse> update(@Valid @RequestBody TaskTitleRequest taskTitleRequest, @RequestBody TaskRequest taskRequest) {
        return ResponseEntity.ok(taskService.update(taskTitleRequest, taskRequest));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@Valid @RequestBody TaskTitleRequest taskTitleRequest) {
        taskService.delete(taskTitleRequest);
        return ResponseEntity.ok().build();
    }
}
