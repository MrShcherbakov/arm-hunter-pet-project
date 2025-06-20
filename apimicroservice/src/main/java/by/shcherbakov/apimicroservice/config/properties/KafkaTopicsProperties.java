package by.shcherbakov.apimicroservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "topics")
public class KafkaTopicsProperties {
    private final String userFindRequest;
    private final String userFindResponse;
    private final String userSaveRequest;
}
