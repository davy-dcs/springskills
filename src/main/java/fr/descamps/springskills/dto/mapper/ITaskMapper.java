package fr.descamps.springskills.dto.mapper;

import fr.descamps.springskills.domain.Task;
import fr.descamps.springskills.dto.request.task.TaskRequest;
import fr.descamps.springskills.dto.response.task.TaskResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ITaskMapper {
    TaskResponse taskToTaskResponse(Task task);
    List<TaskResponse> tasksToTaskResponseList(List<Task> tasks);
    Task taskRequestToTask(TaskRequest taskRequest);
    @Mapping(target = "id", ignore = true)
    void updatePartialTask(TaskRequest taskRequest, @MappingTarget Task task);
}
