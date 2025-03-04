package fr.descamps.springskills.component;

import fr.descamps.springskills.event.TaskCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class TaskEventListener {
    @EventListener
    public void handleTaskCreateEvent(TaskCreatedEvent event) {
        log.info("Event lancé: {}", event);
    }
}
