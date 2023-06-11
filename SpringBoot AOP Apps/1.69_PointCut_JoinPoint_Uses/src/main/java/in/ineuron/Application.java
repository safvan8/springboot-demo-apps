package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Annotates that this class is the starting point of the Spring Boot Application
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args); // Runs the Spring Boot Application
	}

}
