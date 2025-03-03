package fr.descamps.springskills.dto.request.task;

import fr.descamps.springskills.domain.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;

public record TaskRequest(
        @NotBlank(message = "Title must not be empty")
        @Size(max = 100, message = "The title cannot exceed 100 characters")
        String title,
        @Size(max = 255, message = "The description cannot exceed 255 characters")
        String description,
        @FutureOrPresent(message = "The date must not be exceeded")
        LocalDate dueDate,
        @Enumerated(EnumType.STRING)
        TaskStatus status
) implements Serializable {
}
