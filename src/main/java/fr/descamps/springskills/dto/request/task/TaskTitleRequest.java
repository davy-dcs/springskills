package fr.descamps.springskills.dto.request.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public record TaskTitleRequest(
        @NotBlank(message = "Title must not be empty")
        @Size(max = 100, message = "The title cannot exceed 100 characters")
        String title
) implements Serializable {
}
