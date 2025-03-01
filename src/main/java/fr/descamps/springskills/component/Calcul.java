package fr.descamps.springskills.component;

import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Component
@Scope("prototype")
public class Calcul {
    private Integer quantity;
    private Integer price;

    public Integer calculSomme() {
        return quantity * price;
    }
}
