package by.shcherbakov.apimicroservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "general")
public class GeneralProperties {
    private final List<String> bootstrapServers;
}
