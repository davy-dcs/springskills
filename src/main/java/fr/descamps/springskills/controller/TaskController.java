package fr.descamps.springskills.controller;

import fr.descamps.springskills.dto.request.task.TaskRequest;
import fr.descamps.springskills.dto.request.task.TaskRequestTaskTitleRequest;
import fr.descamps.springskills.dto.request.task.TaskTitleRequest;
import fr.descamps.springskills.dto.response.task.TaskResponse;
import fr.descamps.springskills.service.ITaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<TaskResponse>> getAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return ResponseEntity.ok(taskService.getAll(page, size));
    }

    @GetMapping("/title")
    public ResponseEntity<TaskResponse> getByTitle(@RequestBody TaskTitleRequest taskTitleRequest) {
        return ResponseEntity.ok(taskService.getByTitle(taskTitleRequest));
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody TaskRequest taskRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(taskRequest));
    }

    @PatchMapping
    public ResponseEntity<TaskResponse> update(@RequestBody TaskRequestTaskTitleRequest taskRequestTaskTitleRequest) {
        return ResponseEntity.ok(taskService.update(taskRequestTaskTitleRequest));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody TaskTitleRequest taskTitleRequest) {
        taskService.delete(taskTitleRequest);
        return ResponseEntity.ok().build();
    }
}
