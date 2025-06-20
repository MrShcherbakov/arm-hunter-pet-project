package by.shcherbakov.apimicroservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;

@Data
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {
    private final ArrayList<String> bootstrapServers;
}
