package fr.descamps.springskills.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HomeServiceImplTest {

    @Autowired
    private HomeServiceImpl homeService;

    @Test
    void getHomeService() {
        String expected = "HomeService Autowired";
        String actual = homeService.getHomeService().getName();
        assertEquals(expected, actual);
    }
}