package fr.descamps.springskills.service.impl;

import fr.descamps.springskills.domain.Task;
import fr.descamps.springskills.domain.TaskStatus;
import fr.descamps.springskills.dto.mapper.ITaskMapper;
import fr.descamps.springskills.dto.response.task.TaskResponse;
import fr.descamps.springskills.repositories.ITaskRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RequiredArgsConstructor
@SpringBootTest
class TaskServiceImplTest {
    @Mock
    private ITaskRepository taskRepository;
    @Mock
    private ITaskMapper taskMapper;

    @Autowired
    private TaskServiceImpl taskService;

    Task task1;
    Task task2;
    TaskResponse taskResponse1;
    TaskResponse taskResponse2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        task1 = mock(Task.class);
        task2 = mock(Task.class);
        taskResponse1 = mock(TaskResponse.class);
        taskResponse2 = mock(TaskResponse.class);

        Random random = new Random();
        int randomTask1 = random.nextInt(5) + 1;
        int randomTask2 = random.nextInt(5) + 1;

        when(task1.getId()).thenReturn(1L);
        when(task1.getTitle()).thenReturn("Titre 1");
        when(task1.getDescription()).thenReturn("Description 1");
        when(task1.getStatus()).thenReturn(TaskStatus.IN_PROGRESS);
        when(task1.getDueDate()).thenReturn(Date.valueOf(LocalDate.now().plusDays(randomTask1)));

        when(task2.getId()).thenReturn(2L);
        when(task2.getTitle()).thenReturn("Titre 2");
        when(task2.getDescription()).thenReturn("Description 2");
        when(task2.getStatus()).thenReturn(TaskStatus.TO_DO);
        when(task2.getDueDate()).thenReturn(Date.valueOf(LocalDate.now().plusDays(randomTask2)));

        when(taskResponse1.title()).thenReturn("Titre 1");
        when(taskResponse1.description()).thenReturn("Description 1");
        when(taskResponse1.status()).thenReturn(TaskStatus.IN_PROGRESS);
        when(taskResponse1.dueDate()).thenReturn(Date.valueOf(LocalDate.now().plusDays(randomTask1)));

        when(taskResponse2.title()).thenReturn("Titre 2");
        when(taskResponse2.description()).thenReturn("Description 2");
        when(taskResponse2.status()).thenReturn(TaskStatus.TO_DO);
        when(taskResponse2.dueDate()).thenReturn(Date.valueOf(LocalDate.now().plusDays(randomTask2)));

        // Global Given
        when(taskRepository.findAll()).thenReturn(List.of(task1, task2));
        when(taskMapper.tasksToTaskResponseList(List.of(task1, task2))).thenReturn(List.of(taskResponse1, taskResponse2));
    }

    @Test
    void getAll() {
        // When
        List<TaskResponse> actual = taskService.getAll();
        // Then
        assertNotNull(actual);
        assertEquals(2, actual.size());
        assertEquals("Title 1", actual.get(0).title());
        assertEquals("Description 1", actual.get(0).description());
        assertEquals(TaskStatus.IN_PROGRESS, actual.get(0).status());
        assertTrue(actual.get(0).dueDate().toInstant().isAfter(Instant.now()), "Future date must be later than current date");

        assertEquals("Title 2", actual.get(1).title());
        assertEquals("Description 2", actual.get(1).description());
        assertEquals(TaskStatus.TO_DO, actual.get(1).status());
        assertTrue(actual.get(1).dueDate().toInstant().isAfter(Instant.now()), "Future date must be later than current date");

        verify(taskRepository, times(1)).findAll();
        verify(taskMapper, times(1)).tasksToTaskResponseList(anyList());
    }

    @Test
    void getByTitle() {
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