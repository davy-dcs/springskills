package fr.descamps.springskills.component;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SpringskillsBeanPostProcessor implements BeanPostProcessor {
    @PostConstruct
    public void init() {
        System.out.println("Bean post processor start");
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Avant init : " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Après init : " + beanName);
        return bean;
    }
}
