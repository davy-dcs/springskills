package fr.descamps.springskills.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TaskBadRequestException extends RuntimeException {
    public TaskBadRequestException(String message) {
        super(message);
    }
}
