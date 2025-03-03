package fr.descamps.springskills.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 100)
    private String title;
    private String description;
    @FutureOrPresent
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @PrePersist
    public void prePersist() {
        this.status = TaskStatus.TO_DO;
    }
}
