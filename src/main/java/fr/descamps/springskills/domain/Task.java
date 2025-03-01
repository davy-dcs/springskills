package fr.descamps.springskills.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Builder
@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 100)
    private String title;
    private String description;
    private Date dueDate;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @PrePersist
    public void prePersist() {
        this.status = TaskStatus.TO_DO;
    }
}
