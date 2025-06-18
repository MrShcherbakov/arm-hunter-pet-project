package by.shcherbakov.apimicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("by.shcherbakov.apimicroservice.config.properties")
public class ApimicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApimicroserviceApplication.class, args);
	}

}
