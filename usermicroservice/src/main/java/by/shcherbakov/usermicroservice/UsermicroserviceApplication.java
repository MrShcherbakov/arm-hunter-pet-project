package by.shcherbakov.usermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("by.shcherbakov.usermicroservice.config.properties")
public class UsermicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermicroserviceApplication.class, args);
	}

}
