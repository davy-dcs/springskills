package fr.descamps.springskills.dto.request.task;

import java.io.Serializable;
import java.sql.Date;

public record TaskRequest(
        String title,
        String description,
        Date dueDate
) implements Serializable {
}
