package fr.descamps.springskills.dto.mapper;

import fr.descamps.springskills.domain.Task;
import fr.descamps.springskills.dto.request.task.TaskRequest;
import fr.descamps.springskills.dto.response.task.TaskResponse;
import org.mapstruct.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ITaskMapper {
    TaskResponse taskToTaskResponse(Task task);
    Task taskRequestToTask(TaskRequest taskRequest);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", source = "status")
    void updatePartialTask(TaskRequest taskRequest, @MappingTarget Task task);

    default Page<TaskResponse> pageableToPageTaskResponse(Page<Task> tasks) {
        List<TaskResponse> taskResponses = tasks.getContent().stream()
                .map(this::taskToTaskResponse) // Mapper chaque tâche vers TaskResponse
                .toList(); // ou collect(Collectors.toList()) si tu utilises Java 8

        return new PageImpl<>(taskResponses, tasks.getPageable(), tasks.getTotalElements());
    }
}
