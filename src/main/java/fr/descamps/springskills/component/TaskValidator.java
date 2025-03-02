package fr.descamps.springskills.component;

import fr.descamps.springskills.dto.request.task.TaskRequest;
import fr.descamps.springskills.dto.request.task.TaskTitleRequest;
import fr.descamps.springskills.error.exception.TaskBadRequestException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class TaskValidator {
    private final Validator validator;

    public void taskTitleRequestValidate(TaskTitleRequest taskTitleRequest) {
        Set<ConstraintViolation<TaskTitleRequest>> violations = validator.validate(taskTitleRequest);

        if (!violations.isEmpty()) {
            String message = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .findFirst().orElse("Title is invalid");
            throw new TaskBadRequestException(message);
        }
    }

    public void taskRequestValidate(TaskRequest taskRequest) {
        Set<ConstraintViolation<TaskRequest>> violations = validator.validate(taskRequest);

        if (!violations.isEmpty()) {
            String message = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .findFirst().orElse("Invalid data");
            throw new TaskBadRequestException(message);
        }
    }
}
