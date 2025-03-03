package fr.descamps.springskills.dto.request.task;

public record TaskRequestTaskTitleRequest(
        TaskTitleRequest taskTitleRequest,
        TaskRequest taskRequest
) {
}
