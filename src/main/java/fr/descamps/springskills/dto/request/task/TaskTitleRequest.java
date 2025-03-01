package fr.descamps.springskills.dto.request.task;

import java.io.Serializable;

public record TaskTitleRequest(
        String title
) implements Serializable {
}
