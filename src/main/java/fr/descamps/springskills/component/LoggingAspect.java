package fr.descamps.springskills.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @AfterThrowing(pointcut = "execution(* fr.descamps.springskills.service.impl.*.*(..))", throwing = "ex")
    public void logException(Exception ex) {
        log.error("An error has occurred", ex);
    }

    @AfterReturning(pointcut = "execution(* fr.descamps.springskills.service.impl.*.*(..))", returning = "result")
    public void logTaskSuccess(Object result) {
        log.info("Method executed successfully, result : {}", result);
    }
}
