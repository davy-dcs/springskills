package fr.descamps.springskills.dto.request.task;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.sql.Date;

public record TaskRequest(
        @NotNull(message = "Title is mandatory")
        @Size(max = 100, message = "The title cannot exceed 100 characters")
        String title,
        @Size(max = 255, message = "The description cannot exceed 255 characters")
        String description,
        @Future(message = "The date must not be exceeded")
        Date dueDate
) implements Serializable {
}
