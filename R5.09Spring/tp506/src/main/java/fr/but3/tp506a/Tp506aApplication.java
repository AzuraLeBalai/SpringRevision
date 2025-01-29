package fr.but3.tp506a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Tp506aApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp506aApplication.class, args);
		System.out.println("Hello World");
	}

}
