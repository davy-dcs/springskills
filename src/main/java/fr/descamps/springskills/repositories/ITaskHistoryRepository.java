package fr.descamps.springskills.repositories;

import fr.descamps.springskills.domain.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskHistoryRepository extends JpaRepository<TaskHistory, Long> {
}
