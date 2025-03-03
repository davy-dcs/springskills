package fr.descamps.springskills.dto.response.task;

import fr.descamps.springskills.domain.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;
import java.time.LocalDate;

public record TaskResponse(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status
) implements Serializable {
}
