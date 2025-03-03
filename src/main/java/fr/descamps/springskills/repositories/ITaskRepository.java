package fr.descamps.springskills.repositories;

import fr.descamps.springskills.domain.Task;
import fr.descamps.springskills.domain.TaskStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTitle(String title);
    boolean existsByTitle(String title);
    List<Task> findByStatus(TaskStatus status, Pageable pageable);
    List<Task> findByDueDate(Date date, Pageable pageable);

}
