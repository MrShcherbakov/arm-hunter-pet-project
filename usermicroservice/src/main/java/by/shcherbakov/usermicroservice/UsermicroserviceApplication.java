package by.shcherbakov.usermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@EntityScan("by.shcherbakov.core_domain.entity")
@SpringBootApplication
@ConfigurationPropertiesScan("by.shcherbakov.usermicroservice.config.properties")
public class UsermicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermicroserviceApplication.class, args);
	}

}
