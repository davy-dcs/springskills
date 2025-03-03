package fr.descamps.springskills.service.impl;

import fr.descamps.springskills.component.TaskValidator;
import fr.descamps.springskills.domain.Task;
import fr.descamps.springskills.dto.mapper.ITaskMapper;
import fr.descamps.springskills.dto.request.task.TaskTitleRequest;
import fr.descamps.springskills.dto.response.task.TaskResponse;
import fr.descamps.springskills.error.exception.TaskBadRequestException;
import fr.descamps.springskills.error.exception.TaskNotFoundException;
import fr.descamps.springskills.repositories.ITaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    @Mock
    private ITaskRepository taskRepository;
    @Mock
    private ITaskMapper taskMapper;
    @Mock
    private TaskValidator taskValidator;

    private TaskServiceImpl taskService;

    Task task1;
    Task task2;
    TaskResponse taskResponse1;
    TaskResponse taskResponse2;
    TaskTitleRequest taskTitleRequest;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        taskService = new TaskServiceImpl(taskRepository, taskMapper, taskValidator);
        task1 = mock(Task.class);
        task2 = mock(Task.class);
        taskResponse1 = mock(TaskResponse.class);
        taskResponse2 = mock(TaskResponse.class);
    }

    @Test
    void getAll_ReturnList() {
        // Given
        when(taskRepository.findAll()).thenReturn(List.of(task1, task2));
        when(taskResponse1.title()).thenReturn("Titre 1");
        when(taskResponse2.title()).thenReturn("Titre 2");
        // When
        //List<TaskResponse> actual = taskService.getAll();
        // Then
        //assertNotNull(actual);
        //assertEquals(2, actual.size());
        //assertEquals("Titre 1", actual.get(0).title());
        //assertEquals("Titre 2", actual.get(1).title());
        //verify(taskRepository, times(1)).findAll();
    }
    @Test
    void getAll_ReturnEmptyList() {
        // Given
        when(taskRepository.findAll()).thenReturn(List.of());
        // When
        //List<TaskResponse> actual = taskService.getAll();
        // Then
       // assertNotNull(actual);
       // assertEquals(0, actual.size());
        verify(taskRepository, times(1)).findAll();
    }

    @Test
    void getByTitle_ReturnTaskResponse() {
        // Given
        when(taskRepository.findByTitle(anyString())).thenReturn(Optional.of(task1));
        when(taskMapper.taskToTaskResponse(task1)).thenReturn(taskResponse1);
        when(taskTitleRequest.title()).thenReturn(anyString());
        // When
        TaskResponse actual = taskService.getByTitle(taskTitleRequest);
        // Then
        assertNotNull(actual);
    }

    @Test
    void getByTitle_ReturnTaskNotFoundException() {
        // Given
        TaskTitleRequest taskTitleRequest = new TaskTitleRequest("Titre inexistant");
        when(taskRepository.findByTitle(anyString())).thenReturn(Optional.empty());
        // When + Then
        assertThrows(TaskNotFoundException.class, () -> taskService.getByTitle(taskTitleRequest));
    }

    @Test
    void getByTitle_ReturnTaskBadRequestException() {
        // Given
        TaskTitleRequest taskTitleRequest = new TaskTitleRequest("");
        // When + Then
        assertThrows(TaskBadRequestException.class, () -> taskService.getByTitle(taskTitleRequest));
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}