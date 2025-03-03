package fr.descamps.springskills.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class TaskTitleAlreadyExists extends RuntimeException {
    public TaskTitleAlreadyExists(String message) {
        super(message);
    }
}
