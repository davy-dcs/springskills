package fr.descamps.springskills.service.impl;

import fr.descamps.springskills.domain.HomeService;
import org.springframework.stereotype.Component;

@Component
public class HomeServiceImpl {
    public HomeService getHomeService(){
        return new HomeService();
    }
}
