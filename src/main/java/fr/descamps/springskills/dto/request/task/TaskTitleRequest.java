package fr.descamps.springskills.dto.request.task;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record TaskTitleRequest(
        @NotNull(message = "Title is mandatory")
        @Size(max = 100, message = "The title cannot exceed 100 characters")
        String title
) implements Serializable {
}
