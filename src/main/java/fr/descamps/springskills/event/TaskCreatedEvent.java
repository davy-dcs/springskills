package fr.descamps.springskills.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDate;

@Getter
public class TaskCreatedEvent extends ApplicationEvent {
    private final Long id;
    private final String title;
    private final LocalDate date = LocalDate.now();

    public TaskCreatedEvent(Object source, Long id, String title) {
        super(source);
        this.id = id;
        this.title = title;
    }
}
