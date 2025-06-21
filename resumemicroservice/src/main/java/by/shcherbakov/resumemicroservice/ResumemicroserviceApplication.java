package by.shcherbakov.resumemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan("by.shcherbakov.resumemicroservice.config.properties")
@EntityScan("by.shcherbakov.core_domain.entity")
@SpringBootApplication
public class ResumemicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumemicroserviceApplication.class, args);
	}

}
