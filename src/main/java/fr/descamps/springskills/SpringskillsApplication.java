package fr.descamps.springskills;

import fr.descamps.springskills.service.impl.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringskillsApplication implements CommandLineRunner {
	@Autowired
	HomeServiceImpl homeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringskillsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {;
		System.out.println("Springskills start");
		System.out.println(homeService.getHomeService());
	}
}
