package za.ac.cput.Controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// the below tells spring to scan the whole project for components
@ComponentScan("za.ac.cput")
public class ControllersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllersApplication.class, args);
	}

}
