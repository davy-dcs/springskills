package fr.descamps.springskills.component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Exemple {
    @PostConstruct
    public void init() {
        System.out.println("Bean exemple post construct");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("Bean détruit !");
    }
}
