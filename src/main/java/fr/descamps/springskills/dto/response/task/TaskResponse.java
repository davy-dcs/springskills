package fr.descamps.springskills.dto.response.task;

import fr.descamps.springskills.domain.TaskStatus;

import java.io.Serializable;
import java.sql.Date;

public record TaskResponse(
        String title,
        String description,
        Date dueDate,
        TaskStatus status
) implements Serializable {
}
